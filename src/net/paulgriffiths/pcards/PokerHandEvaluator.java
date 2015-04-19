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
public final class PokerHandEvaluator {
    private final CardCounter counter;
    private final PokerHandScore score;
    
    public PokerHandEvaluator(final PokerHand hand) {
        this.counter = new CardCounter(hand.getCardList());
        this.score = evaluate();
    }
    
    private PokerHandScore evaluate() {
        final PokerHands type = calculateHandType();
        
        switch ( type ) {
            case ROYAL_FLUSH:
                return new PokerHandScore(type);
                
            case STRAIGHT_FLUSH:
                return new PokerHandScore(type,
                        counter.lowestRankByCount(1).getValue());
                
            case FOUR:
                return new PokerHandScore(type,
                        counter.highestRankByCount(4).getValue(),
                        counter.highestRankByCount(1).getValue());
                
            case FULL_HOUSE:
                return new PokerHandScore(type,
                        counter.highestRankByCount(3).getValue(),
                        counter.highestRankByCount(2).getValue());
                
            case FLUSH:
                return new PokerHandScore(type,
                        counter.rankScoreByCount(1));
                
            case STRAIGHT:
                return new PokerHandScore(type,
                        counter.lowestRankByCount(1).getValue());
                
            case THREE:
                return new PokerHandScore(type,
                        counter.highestRankByCount(3).getValue(),
                        counter.rankScoreByCount(1));
                
            case TWO_PAIR:
                return new PokerHandScore(type,
                        counter.highestRankByCount(2).getValue(),
                        counter.lowestRankByCount(2).getValue(),
                        counter.highestRankByCount(1).getValue());
                
            case PAIR:
                return new PokerHandScore(type,
                        counter.highestRankByCount(2).getValue(),
                        counter.rankScoreByCount(1));
                
            case HIGH:
                return new PokerHandScore(type, counter.rankScoreByCount(1));
                
            default:
                throw new UnsupportedOperationException("Poker hand evaluation failed");
        }
    }
    
    private PokerHands calculateHandType() {
        if ( counter.isFlush() && counter.isStraight() ) {
            if ( counter.lowestRankByCount(1) == Ranks.TEN ) {
                return PokerHands.ROYAL_FLUSH;
            }
            else {
                return PokerHands.STRAIGHT_FLUSH;
            }
        }
        else if ( counter.numberRankByCount(4) == 1) {
            return PokerHands.FOUR;
        }
        else if ( counter.numberRankByCount(3) == 1 &&
                  counter.numberRankByCount(2) == 1 ) {
            return PokerHands.FULL_HOUSE;
        }
        else if ( counter.isFlush() ) {
            return PokerHands.FLUSH;
        }
        else if ( counter.isStraight() ) {
            return PokerHands.STRAIGHT;
        }
        else if ( counter.numberRankByCount(3) == 1 ) {
            return PokerHands.THREE;
        }
        else if ( counter.numberRankByCount(2) == 2 ) {
            return PokerHands.TWO_PAIR;
        }
        else if ( counter.numberRankByCount(2) == 1 ) {
            return PokerHands.PAIR;
        }
        else if ( counter.numberRankByCount(1) == 5 ) {
            return PokerHands.HIGH;
        }
        else {
            throw new UnsupportedOperationException("Poker hand evaluation failed");
        }
    }
    
    public PokerHands handType() {
        return score.getHandType();
    }
    
    public boolean beats(final PokerHandEvaluator other) {
        return this.score.compareTo(other.score) > 0;
    }
    
    public boolean losesTo(final PokerHandEvaluator other) {
        return this.score.compareTo(other.score) < 0;
    }
    
    public boolean matches(final PokerHandEvaluator other) {
        return this.score.compareTo(other.score) == 0;
    }
}
