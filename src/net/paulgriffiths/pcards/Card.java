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
    public static final Card ACE_CLUBS = new Card(Ranks.ACE, Suits.CLUBS);
    public static final Card TWO_CLUBS = new Card(Ranks.TWO, Suits.CLUBS);
    public static final Card THREE_CLUBS = new Card(Ranks.THREE, Suits.CLUBS);
    public static final Card FOUR_CLUBS = new Card(Ranks.FOUR, Suits.CLUBS);
    public static final Card FIVE_CLUBS = new Card(Ranks.FIVE, Suits.CLUBS);
    public static final Card SIX_CLUBS = new Card(Ranks.SIX, Suits.CLUBS);
    public static final Card SEVEN_CLUBS = new Card(Ranks.SEVEN, Suits.CLUBS);
    public static final Card EIGHT_CLUBS = new Card(Ranks.EIGHT, Suits.CLUBS);
    public static final Card NINE_CLUBS = new Card(Ranks.NINE, Suits.CLUBS);
    public static final Card TEN_CLUBS = new Card(Ranks.TEN, Suits.CLUBS);
    public static final Card JACK_CLUBS = new Card(Ranks.JACK, Suits.CLUBS);
    public static final Card QUEEN_CLUBS = new Card(Ranks.QUEEN, Suits.CLUBS);
    public static final Card KING_CLUBS = new Card(Ranks.KING, Suits.CLUBS);
    public static final Card ACE_HEARTS = new Card(Ranks.ACE, Suits.HEARTS);
    public static final Card TWO_HEARTS = new Card(Ranks.TWO, Suits.HEARTS);
    public static final Card THREE_HEARTS = new Card(Ranks.THREE, Suits.HEARTS);
    public static final Card FOUR_HEARTS = new Card(Ranks.FOUR, Suits.HEARTS);
    public static final Card FIVE_HEARTS = new Card(Ranks.FIVE, Suits.HEARTS);
    public static final Card SIX_HEARTS = new Card(Ranks.SIX, Suits.HEARTS);
    public static final Card SEVEN_HEARTS = new Card(Ranks.SEVEN, Suits.HEARTS);
    public static final Card EIGHT_HEARTS = new Card(Ranks.EIGHT, Suits.HEARTS);
    public static final Card NINE_HEARTS = new Card(Ranks.NINE, Suits.HEARTS);
    public static final Card TEN_HEARTS = new Card(Ranks.TEN, Suits.HEARTS);
    public static final Card JACK_HEARTS = new Card(Ranks.JACK, Suits.HEARTS);
    public static final Card QUEEN_HEARTS = new Card(Ranks.QUEEN, Suits.HEARTS);
    public static final Card KING_HEARTS = new Card(Ranks.KING, Suits.HEARTS);
    public static final Card ACE_SPADES = new Card(Ranks.ACE, Suits.SPADES);
    public static final Card TWO_SPADES = new Card(Ranks.TWO, Suits.SPADES);
    public static final Card THREE_SPADES = new Card(Ranks.THREE, Suits.SPADES);
    public static final Card FOUR_SPADES = new Card(Ranks.FOUR, Suits.SPADES);
    public static final Card FIVE_SPADES = new Card(Ranks.FIVE, Suits.SPADES);
    public static final Card SIX_SPADES = new Card(Ranks.SIX, Suits.SPADES);
    public static final Card SEVEN_SPADES = new Card(Ranks.SEVEN, Suits.SPADES);
    public static final Card EIGHT_SPADES = new Card(Ranks.EIGHT, Suits.SPADES);
    public static final Card NINE_SPADES = new Card(Ranks.NINE, Suits.SPADES);
    public static final Card TEN_SPADES = new Card(Ranks.TEN, Suits.SPADES);
    public static final Card JACK_SPADES = new Card(Ranks.JACK, Suits.SPADES);
    public static final Card QUEEN_SPADES = new Card(Ranks.QUEEN, Suits.SPADES);
    public static final Card KING_SPADES = new Card(Ranks.KING, Suits.SPADES);
    public static final Card ACE_DIAMONDS = new Card(Ranks.ACE, Suits.DIAMONDS);
    public static final Card TWO_DIAMONDS = new Card(Ranks.TWO, Suits.DIAMONDS);
    public static final Card THREE_DIAMONDS = new Card(Ranks.THREE, Suits.DIAMONDS);
    public static final Card FOUR_DIAMONDS = new Card(Ranks.FOUR, Suits.DIAMONDS);
    public static final Card FIVE_DIAMONDS = new Card(Ranks.FIVE, Suits.DIAMONDS);
    public static final Card SIX_DIAMONDS = new Card(Ranks.SIX, Suits.DIAMONDS);
    public static final Card SEVEN_DIAMONDS = new Card(Ranks.SEVEN, Suits.DIAMONDS);
    public static final Card EIGHT_DIAMONDS = new Card(Ranks.EIGHT, Suits.DIAMONDS);
    public static final Card NINE_DIAMONDS = new Card(Ranks.NINE, Suits.DIAMONDS);
    public static final Card TEN_DIAMONDS = new Card(Ranks.TEN, Suits.DIAMONDS);
    public static final Card JACK_DIAMONDS = new Card(Ranks.JACK, Suits.DIAMONDS);
    public static final Card QUEEN_DIAMONDS = new Card(Ranks.QUEEN, Suits.DIAMONDS);
    public static final Card KING_DIAMONDS = new Card(Ranks.KING, Suits.DIAMONDS);
    
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
