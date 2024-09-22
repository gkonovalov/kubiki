package com.gkonovalov;

import com.gkonovalov.components.Grid;
import com.gkonovalov.components.shapes.Dot;
import com.gkonovalov.components.Point;
import com.gkonovalov.components.Shape;
import com.gkonovalov.components.Shapes;
import com.gkonovalov.listeners.KeyListener;
import com.gkonovalov.components.Direction;
import com.gkonovalov.components.GameStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static com.gkonovalov.utils.Constants.*;
import static com.gkonovalov.utils.StringUtils.showGameOverMessage;
import static com.gkonovalov.utils.StringUtils.showWelcomeMessage;

/*
 * Copyright (C) 2024 Georgiy Konovalov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * <p>
 * This class represents the main game logic and user interface for the Kubiki game.
 * The class handles game initialization, rendering, user input, and game state management.
 * It provides methods to start, stop, and restart the game, as well as handle
 * game updates and user interactions.
 * </p>
 */
public class Kubiki extends JPanel implements KeyListener, Runnable {

    private Grid grid;
    private Shapes shapes;
    private Shape shape;
    private GameStatus status;

    private Thread gameThread;

    private int score;
    private int speed;

    public Kubiki() {
        init();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle(STRING_APP_NAME);
        window.add(new Kubiki());
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void init() {
        grid = new Grid();
        shapes = new Shapes();

        resetState(GameStatus.READY);

        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
    }

    private void resetState(GameStatus newStatus) {
        status = newStatus;
        shape = shapes.getRandomShape();
        score = 0;
        speed = SPEED;

        grid.clear();
    }

    private void startGame() {
        resetState(GameStatus.PLAYING);

        gameThread = new Thread(this);
        gameThread.start();
    }

    private void restartGame() {
        stopGame();
        resetState(GameStatus.READY);
    }

    private void stopGame() {
        if (gameThread != null) {
            gameThread.interrupt();
            gameThread = null;
        }

        grid.clear();
    }

    @Override
    protected void paintComponent(Graphics gOld) {
        super.paintComponent(gOld);

        Graphics2D g = (Graphics2D) gOld.create();

        renderUI(g);

        switch (status) {
            case READY:
                showWelcomeMessage(g);
                break;
            case GAME_OVER:
                showGameOverMessage(g, score);
                break;
            case PLAYING:
                drawMovingBox(g);
                break;
        }

        g.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            restartGame();
        }

        if (isPlaying()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    rotate();
                    break;
                case KeyEvent.VK_DOWN:
                    drop();
                    break;
                default:
                    break;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                startGame();
            }
        }

        repaint();
    }

    private void rotate() {
        if (shape instanceof Dot) {
            return;
        }

        if (grid.canMoveWithRotation(shape)) {
            shape.rotate();
        }
    }

    private void move(Direction direction) {
        if (grid.canMove(shape, direction)) {
            shape.updatePosition(direction);
        }
    }

    private void drop() {
        while (grid.canMove(shape, Direction.DOWN)) {
            shape.updatePosition(Direction.DOWN);
            repaint();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && status != GameStatus.GAME_OVER) {
            sleep();

            if (isPlaying()) {
                if (grid.canMove(shape, Direction.DOWN)) {
                    move(Direction.DOWN);
                } else {
                    handleLanding();
                }
                repaint();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void renderUI(Graphics2D g) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (!grid.isEmpty(row, col)) {
                    drawBox(g, row, col, shapes.getShapeById(grid.getShapeId(row, col)).getColor());
                }
            }
        }
    }

    private void drawMovingBox(Graphics2D g) {
        for (Point point : shape.getShape()) {
            int row = shape.getPosition().x + point.y;
            int col = shape.getPosition().y + point.x;

            drawBox(g, row, col, shape.getColor());
        }
    }

    private void drawBox(Graphics2D g, int r, int c, Color color) {
        int x = c * BLOCK_SIZE;
        int y = r * BLOCK_SIZE;

        g.setColor(color);
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }

    private void handleLanding() {
        landShape();

        if (shape.getPosition().x <= 2) {
            status = GameStatus.GAME_OVER;
            stopGame();

            return;
        }

        int removedLines = grid.removeFilledLines();

        if (removedLines > 0) {
            score += 100 * removedLines;
            if (speed - (10 * removedLines) > 0) {
                speed -= 10 * removedLines;
            }
        }

        generateRandomShape();
    }

    private void landShape() {
        for (Point point : shape.getShape()) {
            int row = shape.getPosition().x + point.y;
            int col = shape.getPosition().y + point.x;

            grid.putShape(row, col, shape.getId());
        }
    }

    private void generateRandomShape() {
        Shape newShape = shapes.getRandomShape();

        while (newShape.getId() == shape.getId()) {
            newShape = shapes.getRandomShape();
        }

        shape = newShape;
    }

    private boolean isPlaying() {
        return status == GameStatus.PLAYING;
    }
}
