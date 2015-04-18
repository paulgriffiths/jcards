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

/**
 *
 * @author paul
 */
final class RankComboCounter {
    private final TreeSet<Ranks> singles = new TreeSet<>();
    private final TreeSet<Ranks> pairs = new TreeSet<>();
    private final TreeSet<Ranks> threes = new TreeSet<>();
    private final TreeSet<Ranks> fours = new TreeSet<>();
    
    RankComboCounter(final RankCounter rc) {
        for ( Ranks rank : rc.getRanks() ) {
            switch ( rc.getCount(rank) ) {
                case 1:
                    singles.add(rank);
                    break;
                    
                case 2:
                    pairs.add(rank);
                    break;
                    
                case 3:
                    threes.add(rank);
                    break;
                    
                case 4:
                    fours.add(rank);
                    break;
            }
        }
    }
    
    public int numberSingles() {
        return singles.size();
    }
    
    public int numberPairs() {
        return pairs.size();
    }
    
    public int numberThrees() {
        return threes.size();
    }
    
    public int numberFours() {
        return fours.size();
    }
    
    public Ranks lowestSingle() {
        return singles.first();
    }
    
    public Ranks highestSingle() {
        return singles.last();
    }
}
