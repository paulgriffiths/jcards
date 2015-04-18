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
    private int numberDistinctRanks;
    private int numberDistinctSuits;
    private int highestSingleRankValue = -1;
    private int lowestSingleRankValue = -1;
    
    public CardCount(final CardList list) {
        suitIndexCount = new int[Suits.highestIndex() + 1];
        rankValueCount = new int[Ranks.highestValue() + 1];
        rankComboCount = new int[list.size()];
        
        for ( Card card : list ) {
            incrementRankAndSuitCount(card);
        }
        
        for ( Ranks rank : Ranks.values() ) {
            incrementComboCount(rank.getValue());
            
            if ( isRankValuePresent(rank.getValue()) ) {
                numberDistinctRanks += 1;
                
                if ( isRankValueSingle(rank.getValue()) ) {
                    setHighestSingleRankValue(rank.getValue());
                    setLowestSingleRankValueIfNotSet(rank.getValue());
                }
            }
        }
        
        for ( int n : suitIndexCount ) {
            if ( n > 0 ) {
                numberDistinctSuits +=1 ;
            }
        }
    }
    
    private void incrementRankAndSuitCount(final Card card) {
        suitIndexCount[card.getSuit().getIndex()] += 1;
        rankValueCount[card.getRank().getValue()] += 1;
    }
    
    private void incrementComboCount(final int value) {
        rankComboCount[rankValueCount[value]] += 1;
    }
    
    private boolean isRankValueSingle(final int value) {
        return rankValueCount[value] == 1;
    }
    
    private boolean isRankValuePresent(final int value) {
        return rankValueCount[value] > 0;
    }
    
    private void setHighestSingleRankValue(final int value) {
        highestSingleRankValue = value;
    }
    
    private void setLowestSingleRankValueIfNotSet(final int value) {
        if ( lowestSingleRankValue == - 1 ) {
            lowestSingleRankValue = value;
        }
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
        return numberDistinctRanks;
    }
    
    public int numberSuits() {
        return numberDistinctSuits;
    }
    
    public boolean isFlush() {
        return numberDistinctSuits == 1;
    }
    
    public boolean hasSingles() {
        return highestSingleRankValue != -1;
    }
    
    public Ranks highRank() {
        return Ranks.getFromValue(highestSingleRankValue);
    }
    
    public Ranks lowRank() {
        return Ranks.getFromValue(lowestSingleRankValue);
    }
}
