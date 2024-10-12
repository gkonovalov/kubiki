package com.gkonovalov.components.shapes;

import com.gkonovalov.components.Point;

import static com.gkonovalov.components.Colors.*;

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
 * This class represents the short "Angle" shape, extending the Shape class.
 * It initializes an "Angle" configuration with coordinates (0,0), (-1,-1), (0,-1)
 * and assigns a pink color to it.
 * </p>
 */
public class Angle extends Shape {

    public Angle() {
        super(1, PINK, new Point[]{
                new Point(0, 0),
                new Point(-1, -1),
                new Point(0, -1)
        });
    }
}
