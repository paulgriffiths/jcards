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

import java.util.*;

/**
 *
 * @author paul
 */
public final class CardList implements Iterable<Card> {
    private final List<Card> cardsList;
    
    public CardList() {
        cardsList = new ArrayList();
    }
    
    public CardList(final Card card, final Card... cards) {
        this();
        cardsList.add(card);
        cardsList.addAll(Arrays.asList(cards));
    }
    
    public CardList(final CardList list) {
        this();
        this.cardsList.addAll(list.cardsList);
    }
    
    public int size() {
        return cardsList.size();
    }
    
    public boolean isEmpty() {
        return cardsList.isEmpty();
    }
    
    public void clear() {
        cardsList.clear();
    }
    
    public Card get(final int index) {
        return cardsList.get(index);
    }
    
    public void add(final int index, final Card card) {
        cardsList.add(index, card);
    }
    
    public void add(final CardList list) {
        this.cardsList.addAll(list.cardsList);
    }
    
    public void add(final Card card, Card... cards) {
        cardsList.add(card);
        cardsList.addAll(Arrays.asList(cards));
    }
    
    public boolean remove(final Card card) {
        return cardsList.remove(card);
    }
    
    public Card remove(final int index) {
        return cardsList.remove(index);
    }
    
    public Card exchange(final int index, final Card card) {
        return cardsList.set(index, card);
    }
    
    public void shuffle() {
        Collections.shuffle(cardsList);
    }
    
    public boolean contains(final Card card) {
        return cardsList.contains(card);
    }
    
    @Override
    public Iterator<Card> iterator() {
        return cardsList.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        String separator = null;
        for ( Card card : cardsList ) {
            if ( separator == null ) {
                separator = ",";
            }
            else {
                sb.append(separator);
            }
            
            sb.append(card);
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}
