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

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author paul
 */
final class SuitCounter {
    private final Map<Suits, Integer> map = new TreeMap<>();

    SuitCounter() {
    }
    
    SuitCounter(final CardList list) {
        for ( Card card : list ) {
            countCard(card);
        }
    }
    
    public void countCard(final Card card) {
        final Integer count = map.get(card.getSuit());
        map.put(card.getSuit(), count == null ? 1 : count + 1);
    }

    public int numSuits() {
        return map.size();
    }

    public boolean hasSuit(final Suits suit) {
        return map.containsKey(suit);
    }

    public int getCount(final Suits suit) {
        final Integer count = map.get(suit);
        return count == null ? 0 : count;
    }
    
}
