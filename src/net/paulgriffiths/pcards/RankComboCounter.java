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

import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author paul
 */
final class RankComboCounter {
    private final Map<Integer, TreeSet<Ranks>> ranksMap = new HashMap<>();
    
    RankComboCounter(final RankCounter rc) {
        for ( Ranks rank : rc.getRanks() ) {
            if ( ! hasCount(rc.getCount(rank)) ) {
                ranksMap.put(rc.getCount(rank), new TreeSet<>());
            }            
            ranksMap.get(rc.getCount(rank)).add(rank);
        }
    }
    
    public boolean hasCount(final int count) {
        return countSet(count) == null ? false : true;
    }
    
    private TreeSet<Ranks> countSet(final int count) {
        return ranksMap.get(count) == null ? null : ranksMap.get(count);
    }
    
    public int numberByCount(final int count) {
        return hasCount(count) ? countSet(count).size() : 0;
    }
    
    public Ranks highestByCount(final int count) {
        return hasCount(count) ? countSet(count).last() : null;
    }
    
    public Ranks secondHighestByCount(final int count) {
        if ( hasCount(count) ) {
            return countSet(count).lower(highestByCount(count));
        }
        return null;
    }
    
    public Ranks lowestByCount(final int count) {
        return hasCount(count) ? countSet(count).first() : null;
    }
    
    public int rangeByCount(final int count) {
        return highestByCount(count).valueDifference(lowestByCount(count));
    }
    
    public long scoreByCount(final int count) {
        long score = 0;
        if ( hasCount(count) ) {
            for ( Ranks rank : countSet(count).descendingSet() ) {
                score *= Ranks.highestValue();
                score += rank.getValue();
            }
        }
        return score;
    }
    
}
