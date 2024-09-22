package com.gkonovalov.components;

import java.awt.*;
import static com.gkonovalov.utils.Constants.COLS;

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
 * This class represents a generic shape used in a Kubiki game.
 * It manages the shape's position, rotation, and color. Each shape is initialized
 * with a specific configuration, an ID, and a color.
 *
 * The shape can be rotated 90 degrees clockwise, moved according to directions,
 * and reset to its initial position. The default starting position is row 1
 * and column centered in the grid.
 * </p>
 */
public class Shape {

    private int id;
    private Color color;
    private Point position;
    private Point[] shape;

    public Shape(int id, Color color, Point[] shape) {
        this.shape = shape;
        this.id = id;
        this.color = color;
        this.position = new Point(1, COLS / 2);
    }

    public Point[] getShape() {
        return shape;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void rotate() {
        for (Point s : shape) {
            int tmp = s.x;
            s.x = s.y;
            s.y = -tmp;
        }
    }

    public Point getPosition() {
        return position;
    }

    public void updatePosition(Direction direction) {
        position.x += direction.getY();
        position.y += direction.getX();
    }

    public void resetPosition() {
        position = new Point(1, COLS / 2);
    }
}
