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

import java.util.*;

/**
 *
 * @author paul
 */
public class CardCount {
    private final int[] rankValueCount;
    private final int[] rankComboCount;
    private int distinctRankCount;
    private Ranks highestSingleRank = null;
    private Ranks lowestSingleRank = null;
    private final SuitCounter suitCounter;
    
    public CardCount(final CardList list) {
        rankValueCount = new int[Ranks.highestValue() + 1];
        rankComboCount = new int[list.size()];
        suitCounter = new SuitCounter();
        
        for ( Card card : list ) {
            incrementRankCounts(card);
            suitCounter.countCard(card);
        }
        
        for ( Ranks rank : Ranks.values() ) {
            if ( isRankPresent(rank) ) {
                distinctRankCount += 1;
                incrementComboCount(rank);
                
                if ( isRankSingle(rank) ) {
                    updateHighestSingleRank(rank);
                    updateLowestSingleRank(rank);
                }
            }
        }
    }
    
    private void incrementRankCounts(final Card card) {
        rankValueCount[card.getRank().getValue()] += 1;
    }
    
    private void incrementComboCount(final Ranks rank) {
        rankComboCount[rankValueCount[rank.getValue()]] += 1;
    }
    
    private boolean isRankSingle(final Ranks rank) {
        return rankValueCount[rank.getValue()] == 1;
    }
    
    private boolean isRankPresent(final Ranks rank) {
        return rankValueCount[rank.getValue()] > 0;
    }
    
    private void updateHighestSingleRank(final Ranks rank) {
        if ( highestSingleRank == null ||
             highestSingleRank.compareTo(rank) < 0 ) {
            highestSingleRank = rank;
        }
    }
    
    private void updateLowestSingleRank(final Ranks rank) {
        if ( lowestSingleRank == null ||
             lowestSingleRank.compareTo(rank) > 0 ) {
            lowestSingleRank = rank;
        }
    }
    
    private boolean isSuitPresent(final Suits suit) {
        return suitCounter.hasSuit(suit);
    }
    
    public int number(final Ranks rank) {
        return rankValueCount[rank.getValue()];
    }
    
    public int number(final Suits suit) {
        return suitCounter.getCount(suit);
    }
    
    public int numberHigh() {
        return rankComboCount[1];
    }
    
    public int numberPair() {
        return rankComboCount[2];
    }
    
    public int numberThree() {
        return rankComboCount[3];
    }
    
    public int numberFour() {
        return rankComboCount[4];
    }
    
    public int numberRanks() {
        return distinctRankCount;
    }
    
    public int numberSuits() {
        //return distinctSuitCount;
        return suitCounter.size();
    }
    
    public boolean isFlush() {
        return suitCounter.size() == 1;
    }
    
    public boolean hasSingles() {
        return highestSingleRank != null;
    }
    
    public Ranks highestSingleRank() {
        return highestSingleRank;
    }
    
    public Ranks lowestSingleRank() {
        return lowestSingleRank;
    }
}

class SuitCounter {
    private final Map<Suits, Integer> map;
    
    SuitCounter() {
        map = new TreeMap<>();
    }
    
    public void countCard(final Card card) {
        if ( map.containsKey(card.getSuit()) ) {
            map.put(card.getSuit(), map.get(card.getSuit()) + 1);
        }
        else {
            map.put(card.getSuit(), 1);
        }
    }
    
    public int size() {
        return map.size();
    }
    
    public boolean hasSuit(final Suits suit) {
        return map.containsKey(suit);
    }
    
    public int getCount(final Suits suit) {
        if ( map.containsKey(suit) ) {
            return map.get(suit);
        }
        else {
            return 0;
        }
    }
}