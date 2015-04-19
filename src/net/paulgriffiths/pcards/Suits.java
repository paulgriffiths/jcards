/*
 * Copyright (C) 2015 Paul Griffiths
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.paulgriffiths.pcards;

/**
 * Playing cards suits enumeration class.
 * 
 * @author  Paul Griffiths
 */
public enum Suits {
    CLUBS ("Clubs", "C", 0),
    HEARTS ("Hearts", "H", 1),
    SPADES ("Spades", "S", 2),
    DIAMONDS ("Diamonds", "D", 3);

    private final String longName;
    private final String shortName;
    private final int index;
    
    Suits(final String longName, final String shortName, final int index) {
        this.longName = longName;
        this.shortName = shortName;
        this.index = index;
    }
    
    public String getLongName() {
        return longName;
    }
    
    public String getShortName() {
        return shortName;
    }
    
    public int getIndex() {
        return index;
    }
    
    public static int lowestIndex() {
        return 0;
    }
    
    public static int highestIndex() {
        return 3;
    }
    
    @Override
    public String toString() {
        return getLongName();
    }
}
