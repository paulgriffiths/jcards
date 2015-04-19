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
package net.paulgriffiths.pcards;

/**
 *
 * @author paul
 */
public class Hand {
    private final CardList cardsList;
    
    public Hand(final Card card, final Card... cards) {
        cardsList = new CardList(card, cards);
    }
    
    public Hand(final CardList list) {
        cardsList = new CardList(list);
    }
    
    public Hand(final Hand hand) {
        cardsList = new CardList(hand.cardsList);
    }
    
    public Hand() {
        cardsList = new CardList();
    }
    
    public final CardList getCardList() {
        return new CardList(cardsList);
    }
    
    public final int size() {
        return cardsList.size();
    }
    
    @Override
    public String toString() {
        return cardsList.toString();
    }
}
