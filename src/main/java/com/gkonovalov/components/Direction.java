package com.gkonovalov.components;

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
 * This enum defines the possible movement directions for shapes within the grid.
 * Each direction is associated with a change in the x and y coordinates,
 * representing left, right, and down movements.
 * </p>
 */
public enum Direction {

    LEFT(-1, 0),
    RIGHT(1, 0),
    DOWN(0, 1),
    HOLD(0, 0);

    private Point point;

    Direction(int x, int y) {
        this.point = new Point(x, y);
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }
}
