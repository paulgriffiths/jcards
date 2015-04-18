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
    private final List<Card> list;
    
    public CardList() {
        list = new ArrayList();
    }
    
    public CardList(final CardList list) {
        this();
        this.list.addAll(list.list);
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void clear() {
        list.clear();
    }
    
    public Card get(final int index) {
        return list.get(index);
    }
    
    public void add(final Card card) {
        list.add(card);
    }
    
    public void add(final int index, final Card card) {
        list.add(index, card);
    }
    
    public void add(final CardList list) {
        this.list.addAll(list.list);
    }
    
    public boolean remove(final Card card) {
        return list.remove(card);
    }
    
    public void remove(final int index) {
        list.remove(index);
    }
    
    public Card exchange(final int index, final Card card) {
        return list.set(index, card);
    }
    
    public void shuffle() {
        Collections.shuffle(list);
    }
    
    public boolean contains(final Card card) {
        return list.contains(card);
    }
    
    @Override
    public Iterator<Card> iterator() {
        return list.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        String separator = null;
        for ( Card card : list ) {
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
