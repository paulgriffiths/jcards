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
            if ( counter.lowestRankByCount(1) == Ranks.TEN ) {
                return new PokerHandScore(PokerHands.ROYAL_FLUSH);
            }
            else {
                return new PokerHandScore(PokerHands.STRAIGHT_FLUSH,
                                          counter.lowestRankByCount(1).getValue());
            }
        }
        else if ( counter.numberRankByCount(4) == 1) {
            return new PokerHandScore(PokerHands.FOUR,
                                      counter.highestRankByCount(4).getValue(),
                                      counter.highestRankByCount(1).getValue());
        }
        else if ( counter.numberRankByCount(3) == 1 &&
                  counter.numberRankByCount(2) == 1 ) {
            return new PokerHandScore(PokerHands.FULL_HOUSE,
                                      counter.highestRankByCount(3).getValue(),
                                      counter.highestRankByCount(2).getValue());
        }
        else if ( counter.isFlush() ) {
            return new PokerHandScore(PokerHands.FLUSH,
                                      counter.rankScoreByCount(1));
        }
        else if ( counter.isStraight() ) {
            return new PokerHandScore(PokerHands.STRAIGHT,
                                      counter.lowestRankByCount(1).getValue());
        }
        else if ( counter.numberRankByCount(3) == 1 ) {
            return new PokerHandScore(PokerHands.THREE,
                                      counter.highestRankByCount(3).getValue(),
                                      counter.rankScoreByCount(1));
        }
        else if ( counter.numberRankByCount(2) == 2 ) {
            return new PokerHandScore(PokerHands.TWO_PAIR,
                                      counter.highestRankByCount(2).getValue(),
                                      counter.lowestRankByCount(2).getValue(),
                                      counter.highestRankByCount(1).getValue());
        }
        else if ( counter.numberRankByCount(2) == 1 ) {
            return new PokerHandScore(PokerHands.PAIR,
                                      counter.highestRankByCount(2).getValue(),
                                      counter.rankScoreByCount(1));
        }
        else if ( counter.numberRankByCount(1) == 5 ) {
            return new PokerHandScore(PokerHands.HIGH, counter.rankScoreByCount(1));
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
