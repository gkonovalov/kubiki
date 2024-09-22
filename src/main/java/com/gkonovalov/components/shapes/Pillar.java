package com.gkonovalov.components.shapes;

import com.gkonovalov.components.Point;
import com.gkonovalov.components.Shape;

import java.awt.*;

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
 * This class represents the short "Pillar" shape, extending the Shape class.
 * It initializes a straight vertical line with coordinates (0,0), (0,1)
 * and assigns a violet color to it.
 * </p>
 */
public class Pillar extends Shape {

    public Pillar() {
        super(2,  new Color(185, 15, 255, 255), new Point[]{
                new Point(0, 0),
                new Point(0, 1)
        });
    }
}
