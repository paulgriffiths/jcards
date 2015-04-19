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
public final class CardCounter {
    private final SuitCounter suitCounter;
    private final RankCounter rankCounter;
    private final RankComboCounter rankComboCounter;
    private final int numberCards;
    
    public CardCounter(final CardList list) {
        numberCards = list.size();
        suitCounter = new SuitCounter(list);
        rankCounter = new RankCounter(list);
        rankComboCounter = new RankComboCounter(rankCounter);
    }
    
    public int number(final Ranks rank) {
        return rankCounter.getCount(rank);
    }
    
    public int number(final Suits suit) {
        return suitCounter.getCount(suit);
    }
    
    public int numberRanks() {
        return rankCounter.numRanks();
    }
    
    public int numberSuits() {
        return suitCounter.numSuits();
    }
    
    public boolean isFlush() {
        return numberSuits() == 1;
    }
    
    public boolean isStraight() {
        return isAllSingles() && areSinglesStraight();
    }
    
    private boolean areSinglesStraight() {
        return areSinglesNonWheelStraight() || areSinglesWheelStraight();
    }
    
    private boolean areSinglesNonWheelStraight() {
        return hasSingles() &&
               ( (numberSingles() == 1) ||
                 (singlesRange() == numberSingles() - 1) );
    }
    
    private boolean areSinglesWheelStraight() {
        return hasSingles() &&
               ( (numberSingles() == 1 ) ||
                 (highestSingleRank() == Ranks.ACE &&
                  lowestSingleRank() == Ranks.TWO &&
                  (secondHighestSingleRank().valueDifference(lowestSingleRank()) ==
                   numberSingles() - 2)) );
    }
    
    private boolean isAllSingles() {
        return hasSingles() && numberSingles() == numberCards;
    }
    
    private int singlesRange() {
        return rankComboCounter.singlesRange();
    }
    
    public int numberSingles() {
        return rankComboCounter.numberSingles();
    }
    
    public int numberPairs() {
        return rankComboCounter.numberPairs();
    }
    
    public int numberThrees() {
        return rankComboCounter.numberThrees();
    }
    
    public int numberFours() {
        return rankComboCounter.numberFours();
    }
    
    public Ranks lowestPairRank() {
        return rankComboCounter.lowestPair();
    }
    
    public Ranks highestPairRank() {
        return rankComboCounter.highestPair();
    }
    
    public Ranks lowestThreeRank() {
        return rankComboCounter.lowestThree();
    }
    
    public Ranks highestThreeRank() {
        return rankComboCounter.highestThree();
    }
    
    public Ranks lowestFourRank() {
        return rankComboCounter.lowestFour();
    }
    
    public Ranks highestFourRank() {
        return rankComboCounter.highestFour();
    }
    
    public boolean hasSingles() {
        return numberSingles() > 0;
    }
    
    public Ranks highestSingleRank() {
        return rankComboCounter.highestSingle();
    }
    
    private Ranks secondHighestSingleRank() {
        return rankComboCounter.secondHighestSingle();
    }
    
    public Ranks lowestSingleRank() {
        return rankComboCounter.lowestSingle();
    }
    
    public long singlesScore() {
        return rankComboCounter.singlesScore();
    }
}

