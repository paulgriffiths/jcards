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
public final class Deck {
    CardList store;
    CardList discardPile;
    
    public Deck() {
        store = newFullCardList();
        discardPile = new CardList();
    }
    
    public int size() {
        return store.size();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int discardsSize() {
        return discardPile.size();
    }
    
    public Card drawCard() {
        try {
            return store.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            throw new DeckEmptyException("Deck empty");
        }
    }
    
    public CardList drawCards(final int count) {
        CardList newList = new CardList();
        for ( int i = 0; i < count; ++i ) {
            newList.add(drawCard());
        }
        return newList;
    }
    
    public void add(final Card card) {
        store.add(card);
    }
    
    public void add(final CardList list) {
        store.add(list);
    }
    
    public void add(final Hand hand) {
        store.add(hand.getCardList());
    }
    
    public void discard(final Card card) {
        discardPile.add(card);
    }
    
    public void discard(final CardList list) {
        discardPile.add(list);
    }
    
    public void discard(final Hand hand) {
        discardPile.add(hand.getCardList());
    }
    
    public void replaceDiscards() {
        store.add(discardPile);
        discardPile.clear();
    }
    
    public void shuffle() {
        store.shuffle();
    }
    
    public void replaceDiscardsAndShuffle() {
        replaceDiscards();
        shuffle();
    }
    
    private CardList newFullCardList() {
        CardList newList = new CardList();
        for ( Suits suit: Suits.values() ) {
            for ( Ranks rank : Ranks.values() ) {
                newList.add(new Card(rank, suit));
            }
        }
        return newList;
    }
}
