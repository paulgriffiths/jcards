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
    
    public boolean isEmpty() {
        return numberCards() == 0;
    }
    
    public int numberCards() {
        return numberCards;
    }
    
    public boolean hasRank(final Ranks rank) {
        return number(rank) > 0;
    }
    
    public boolean hasSuit(final Suits suit) {
        return number(suit) > 0;
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
    
    public boolean hasRankCount(final int count) {
        return rankComboCounter.hasCount(count);
    }
    
    public int numberRankByCount(final int count) {
        return rankComboCounter.numberByCount(count);
    }
    
    public Ranks highestRankByCount(final int count) {
        return rankComboCounter.highestByCount(count);
    }
    
    public Ranks secondHighestRankByCount(final int count) {
        return rankComboCounter.secondHighestByCount(count);
    }
    
    public Ranks lowestRankByCount(final int count) {
        return rankComboCounter.lowestByCount(count);
    }
    
    public int rankRangeByCount(final int count) {
        return rankComboCounter.rangeByCount(count);
    }
    
    public long rankScoreByCount(final int count) {
        return rankComboCounter.scoreByCount(count);
    }
    
    public boolean isFlush() {
        return numberSuits() == 1;
    }
    
    public boolean isStraight() {
        return isAllSingles() && areSinglesStraight();
    }
    
    private boolean isAllSingles() {
        return !isEmpty() && numberRankByCount(1) == numberCards;
    }
    
    private boolean areSinglesStraight() {
        return areSinglesNonWheelStraight() || areSinglesWheelStraight();
    }
    
    private boolean areSinglesNonWheelStraight() {
        return hasRankCount(1) &&
               ( (numberRankByCount(1) == 1) ||
                 (rankRangeByCount(1) == numberRankByCount(1) - 1) );
    }
    
    private boolean areSinglesWheelStraight() {
        return hasRankCount(1) &&
               ( (numberRankByCount(1) == 1 ) ||
                 (highestRankByCount(1) == Ranks.ACE &&
                  lowestRankByCount(1) == Ranks.TWO &&
                  (secondHighestRankByCount(1).valueDifference(lowestRankByCount(1)) ==
                   numberRankByCount(1) - 2)) );
    }
}