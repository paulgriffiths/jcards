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
public class Card implements Comparable<Card> {
    private final Ranks rank;
    private final Suits suit;
    private final int index;
    
    public Card(final Ranks rank, final Suits suit) {
        this.rank = rank;
        this.suit = suit;
        this.index = rank.getIndex() + 13 * suit.getIndex();
    }
    
    public Ranks getRank() {
        return rank;
    }
    
    public Suits getSuit() {
        return suit;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public String toString() {
        return rank.getShortName() + suit.getShortName();
    }
    
    /**
     * Overriden equals method.
     * 
     * Card objects can be compared only to each other.
     * 
     * @param obj   The comparison object
     * @return      True if they are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        else if ( obj == null ) {
            return false;
        }
        else if ( obj instanceof Card ) {
            if ( index == ((Card) obj).index ) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Overriden hash code method.
     * 
     * @return  The hash code 
     */
    @Override
    public int hashCode() {
        return index;
    }
    
    /**
     * Overriden compareTo() method.
     * 
     * @param card  The card to which to compare
     * @return      1, -1 or 0 if the compared to date is less than,
     *              greater than, or equal to this date, respectively
     */
    @Override
    public int compareTo(Card card) {
        if ( index < card.index ) {
            return -1;
        }
        else if ( index > card.index ) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
