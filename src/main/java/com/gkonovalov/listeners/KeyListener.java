package com.gkonovalov.listeners;

import java.awt.event.KeyEvent;

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
 * This interface extends KeyListener and is specifically designed for handling key events
 * in a Kubiki game context. It provides default implementations for the keyTyped and keyReleased
 * methods, leaving only the keyPressed method to be implemented by the classes that use this interface.
 * The default implementations do nothing, allowing subclasses to focus solely on the keyPressed method.
 * </p>
 */
public interface KeyListener extends java.awt.event.KeyListener {

    @Override
    default void keyTyped(KeyEvent e) {}

    @Override
    default void keyReleased(KeyEvent e) {}
}
