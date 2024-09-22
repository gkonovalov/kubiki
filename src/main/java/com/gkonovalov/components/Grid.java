package com.gkonovalov.components;

import java.util.Arrays;

import static com.gkonovalov.utils.Constants.*;

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
 * This class represents the game grid, managing the placement, movement,
 * and removal of shapes. It also checks for collisions and whether rows
 * are filled, handling the logic for clearing and shifting rows when needed.
 * </p>
 */
public class Grid {

    private int[][] grid;

    public Grid() {
        this.grid = new int[ROWS][COLS];
    }

    public int getShapeId(int row, int col) {
        if (isValidPosition(row, col)) {
            return grid[row][col];
        }
        return -1;
    }

    public void putShape(int row, int col, int shapeId) {
        if (isValidPosition(row, col)) {
            grid[row][col] = shapeId;
        }
    }

    public boolean isEmpty(int row, int col) {
        return getShapeId(row, col) == EMPTY;
    }

    public boolean canMove(Shape shape, Direction direction) {
        return canMove(shape.getShape(), direction, shape.getPosition());
    }

    public boolean canMoveWithRotation(Shape shape) {
        return canMove(rotateShape(shape.getShape()), Direction.HOLD, shape.getPosition());
    }

    private boolean canMove(Point[] shape, Direction direction, Point position) {
        for (Point point : shape) {
            int col = position.y + direction.getX() + point.x;
            int row = position.x + direction.getY() + point.y;

            if (!isValidPosition(row, col) || grid[row][col] != EMPTY) {
                return false;
            }
        }
        return true;
    }

    public int removeFilledLines() {
        int count = 0;

        for (int r = 0; r < ROWS; r++) {
            if (isRowFilled(r)) {
                clearRow(r);
                shiftDownRowsAbove(r);
                count++;
            }
        }

        return count;
    }

    public void clear() {
        for (int[] item : grid) {
            Arrays.fill(item, EMPTY);
        }
    }

    private Point[] rotateShape(Point[] shape) {
        Point[] rotated = new Point[shape.length];

        for (int i = 0; i < shape.length; i++) {
            Point point = shape[i];
            rotated[i] = new Point(point.y, -point.x);
        }
        return rotated;
    }

    private boolean isRowFilled(int row) {
        for (int c = 0; c < COLS; c++) {
            if (grid[row][c] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    private void shiftDownRowsAbove(int startRow) {
        for (int r = startRow; r > 0; r--) {
            grid[r] = Arrays.copyOf(grid[r - 1], COLS);
        }

        Arrays.fill(grid[0], EMPTY);
    }

    private void clearRow(int row) {
        Arrays.fill(grid[row], EMPTY);
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && col >= 0 && row < ROWS && col < COLS;
    }
}
