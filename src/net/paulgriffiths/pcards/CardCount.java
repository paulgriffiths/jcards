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
public class CardCount {
    private final int[] suitIndexCount;
    private final int[] rankValueCount;
    private final int[] rankComboCount;
    private int distinctRankCount;
    private int distinctSuitCount;
    private Ranks highestSingleRank = null;
    private Ranks lowestSingleRank = null;
    
    public CardCount(final CardList list) {
        suitIndexCount = new int[Suits.highestIndex() + 1];
        rankValueCount = new int[Ranks.highestValue() + 1];
        rankComboCount = new int[list.size()];
        
        for ( Card card : list ) {
            incrementRankAndSuitCounts(card);
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
        
        for ( Suits suit : Suits.values() ) {
            if ( isSuitPresent(suit) ) {
                distinctSuitCount += 1;
            }
        }
    }
    
    private void incrementRankAndSuitCounts(final Card card) {
        suitIndexCount[card.getSuit().getIndex()] += 1;
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
        return suitIndexCount[suit.getIndex()] > 0;
    }
    
    public int number(final Ranks rank) {
        return rankValueCount[rank.getValue()];
    }
    
    public int number(final Suits suit) {
        return suitIndexCount[suit.getIndex()];
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
        return distinctSuitCount;
    }
    
    public boolean isFlush() {
        return distinctSuitCount == 1;
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
