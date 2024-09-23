package com.gkonovalov.utils;

import java.awt.*;

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
 * The `StringUtils` class is responsible for rendering various text-based messages
 * within the Kubiki game. It contains methods for displaying important user interface
 * messages such as the "Game Over" screen, the welcome message, and instructions.
 * Additionally, this class provides helper functions for centering text on the game
 * window and printing multiline messages.
 * </p>
 */
public class StringUtils {

    public static void showPauseMessage(Graphics2D g) {
        drawStringCenter(g, STRING_GAME_PAUSED, 32, 235);
    }

    public static void showGameOverMessage(Graphics2D g, int score) {
        drawStringCenter(g, STRING_GAME_OVER, 32, 200);
        drawStringCenter(g, String.format(STRING_YOUR_SCORE, score), 16,235);
        drawStringCenter(g, STRING_PRESS_ENTER_TO_START_AGAIN, 14,270);
    }

    public static void showWelcomeMessage(Graphics2D g) {
        drawStringCenter(g, STRING_APP_NAME, 42, 100);
        drawMultilineMessage(g, STRING_GAME_DESCRIPTION.split("\n"), 14, 60, 140, 15);
        drawMultilineMessage(g, STRING_GAME_INSTRUCTIONS.split("\n"), 14, 170, 270, 17);
    }

    private static void drawStringCenter(Graphics2D g, String text, int size, int y) {
        g.setColor(Color.GREEN);
        g.setFont(new Font(null, Font.BOLD, size));
        g.drawString(text, (FRAME_SIZE - g.getFontMetrics().stringWidth(text)) / 2, y);
    }

    private static void drawMultilineMessage(Graphics2D g, String[] text, int size, int x, int y, int space) {
        g.setColor(Color.GREEN);
        g.setFont(new Font(null, Font.PLAIN, size));

        for (String line : text) {
            g.drawString(line, x, y);
            y += space;
        }
    }
}
