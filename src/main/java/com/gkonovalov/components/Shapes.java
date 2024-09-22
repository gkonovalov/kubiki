package com.gkonovalov.components;

import com.gkonovalov.components.shapes.*;
import java.util.HashMap;
import java.util.Random;

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
 * This class manages a collection of different shapes, represented by the Shape class.
 * It provides functionality to retrieve a random shape or a specific shape by its ID.
 * </p>
 */
public class Shapes {

    private HashMap<Integer, Shape> shapes = new HashMap<>() {{
        put(1, new Dot());
        put(2, new Pillar());
        put(3, new Angle());
        put(4, new Crossbar());
        put(5, new Bowl());
        put(6, new Cross());
    }};

    private Random rnd;

    public Shapes() {
        rnd = new Random();
    }

    public Shape getRandomShape() {
        Shape newShape = shapes.get(rnd.nextInt(shapes.size()) + 1);
        newShape.resetPosition();
        return newShape;
    }

    public Shape getShapeById(int id) {
        return shapes.get(id);
    }
}
