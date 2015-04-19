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
    private final PokerHand hand;
    private final CardCounter counter;
    private final PokerHandScore score;
    
    public PokerHandEvaluator(final PokerHand hand) {
        this.hand = hand;
        this.counter = new CardCounter(hand.getCardList());
        this.score = evaluate();
    }
    
    private PokerHandScore evaluate() {
        if ( counter.isFlush() && counter.isStraight() ) {
            if ( counter.lowestSingleRank() == Ranks.TEN ) {
                return new PokerHandScore(PokerHands.ROYAL_FLUSH);
            }
            else {
                return new PokerHandScore(PokerHands.STRAIGHT_FLUSH,
                                          counter.lowestSingleRank().getValue());
            }
        }
        else if ( counter.numberFours() == 1) {
            return new PokerHandScore(PokerHands.FOUR,
                                      counter.highestFourRank().getValue(),
                                      counter.highestSingleRank().getValue());
        }
        else if ( counter.numberThrees() == 1 && counter.numberPairs() == 1 ) {
            return new PokerHandScore(PokerHands.FULL_HOUSE,
                                      counter.highestThreeRank().getValue(),
                                      counter.highestPairRank().getValue());
        }
        else if ( counter.isFlush() ) {
            return new PokerHandScore(PokerHands.FLUSH,
                                      counter.singlesScore());
        }
        else if ( counter.isStraight() ) {
            return new PokerHandScore(PokerHands.STRAIGHT,
                                      counter.lowestSingleRank().getValue());
        }
        else if ( counter.numberThrees() == 1 ) {
            return new PokerHandScore(PokerHands.THREE,
                                      counter.highestThreeRank().getValue(),
                                      counter.singlesScore());
        }
        else if ( counter.numberPairs() == 2 ) {
            return new PokerHandScore(PokerHands.TWO_PAIR,
                                      counter.highestPairRank().getValue(),
                                      counter.lowestPairRank().getValue(),
                                      counter.highestSingleRank().getValue());
        }
        else if ( counter.numberPairs() == 1 ) {
            return new PokerHandScore(PokerHands.PAIR,
                                      counter.highestPairRank().getValue(),
                                      counter.singlesScore());
        }
        else if ( counter.numberSingles() == 5 ) {
            return new PokerHandScore(PokerHands.HIGH, counter.singlesScore());
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
