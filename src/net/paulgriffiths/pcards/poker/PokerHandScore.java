/*
 * Copyright (C) 2015 paul
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
package net.paulgriffiths.pcards.poker;

/**
 *
 * @author paul
 */
public class PokerHandScore implements Comparable<PokerHandScore> {
    private static final int numberComponents = 3;
    
    private final PokerHands handType;
    private final long[] scoreComponents = new long[numberComponents];
    
    public PokerHandScore(final PokerHands handType) {
        this.handType = handType;
    }
    
    public PokerHandScore(final PokerHands handType, final long primary) {
        this(handType);
        this.scoreComponents[0] = primary;
    }
    
    public PokerHandScore(final PokerHands handType, final long primary,
                          final long secondary) {
        this(handType, primary);
        this.scoreComponents[1] = secondary;
    }
    
    public PokerHandScore(final PokerHands handType, final long primary,
                          final long secondary, final long tertiary) {
        this(handType, primary, secondary);
        this.scoreComponents[2] = tertiary;
    }
    
    public PokerHands getHandType() {
        return handType;
    }
    
    @Override
    public int compareTo(final PokerHandScore other) {
        if ( this == other ) {
            return 0;
        }
        else if ( this.handType.compareTo(other.handType) < 0 ) {
            return -1;
        }
        else if ( this.handType.compareTo(other.handType) > 0 ) {
            return 1;
        }
        else {
            for ( int i = 0; i < numberComponents; ++i ) {
                if ( this.scoreComponents[i] < other.scoreComponents[i] ) {
                    return -1;
                }
                else if ( this.scoreComponents[i] > other.scoreComponents[i] ) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "(" + handType.toString() + "," + scoreComponents[0] + "," +
               scoreComponents[1] + "," + scoreComponents[2] + ")";
    }
}
