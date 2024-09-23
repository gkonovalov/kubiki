package com.gkonovalov.utils;

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
 * This class contains various constants used throughout the Kubiki game.
 * These constants include game configuration parameters, such as the number of rows and columns,
 * block size, frame size, game speed, and string messages displayed to the user.
 * Additionally, it provides paths to resources like sound files and font names.
 * </p>
 */
public class Constants {

    public static int EMPTY = -1;
    public static int ROWS = 16;
    public static int COLS = 16;
    public static int BLOCK_SIZE = 30;
    public static int FRAME_SIZE = ROWS * 30;
    public static int SPEED = 450;

    public static String STRING_APP_NAME = "Kubiki";
    public static String STRING_GAME_DESCRIPTION = "Kubiki is a timeless puzzle game where players must \nmanage falling pieces called \"shapes.\" The primary \ngoal is to create complete horizontal lines of blocks to \nclear them from the game field. As lines are cleared, \nblocks above them fall down, and the player continues \nto work towards achieving the highest score possible.";
    public static String STRING_GAME_INSTRUCTIONS = "Control keys:\n\nEnter: to start the game\nP: to pause the game\n↑: rotate shape\n←: move shape to the left\n→: move shape to the right\n↓: drop shape\nEsc: exit game";
    public static String STRING_GAME_OVER = "Game Over!";
    public static String STRING_GAME_PAUSED = "Game Paused!";
    public static String STRING_YOUR_SCORE = "Your score is: %s";
    public static String STRING_PRESS_ENTER_TO_START_AGAIN = "Press Enter to start again!";

}