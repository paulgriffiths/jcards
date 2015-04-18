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
 *
 * @author paul
 */
public enum Ranks {
    TWO ("Two", "2", 2, 1),
    THREE ("Three", "3", 3, 2),
    FOUR ("Four", "4", 4, 3),
    FIVE ("Five", "5", 5, 4),
    SIX ("Six", "6", 6, 5),
    SEVEN ("Seven", "7", 7, 6),
    EIGHT ("Eight", "8", 8, 7),
    NINE ("Nine", "9", 9, 8),
    TEN ("Ten", "T", 10, 9),
    JACK ("Jack", "J", 11, 10),
    QUEEN ("Queen", "Q", 12, 11),
    KING ("King", "K", 13, 12),
    ACE ("Ace", "A", 14, 0);
    
    private final String longName;
    private final String shortName;
    private final int value;
    private final int index;
    
    Ranks(final String longName, final String shortName,
          final int value, final int index) {
        this.longName = longName;
        this.shortName = shortName;
        this.value = value;
        this.index = index;
    }
    
    public String getLongName() {
        return longName;
    }
    
    public String getShortName() {
        return shortName;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public String toString() {
        return getLongName();
    }
}