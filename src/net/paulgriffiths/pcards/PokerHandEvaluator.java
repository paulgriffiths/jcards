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
    private final PokerHands handType;
    private final CardCounter counter;
    
    public PokerHandEvaluator(final PokerHand hand) {
        this.hand = hand;
        this.counter = new CardCounter(hand.getCardList());
        this.handType = evaluate();
    }
    
    private PokerHands evaluate() {
        if ( counter.isFlush() && counter.isStraight() ) {
            if ( counter.lowestSingleRank() == Ranks.TEN ) {
                return PokerHands.ROYAL_FLUSH;
            }
            else {
                return PokerHands.STRAIGHT_FLUSH;
            }
        }
        else if ( counter.numberFours() == 1) {
            return PokerHands.FOUR;
        }
        else if ( counter.numberThrees() == 1 && counter.numberPairs() == 1 ) {
            return PokerHands.FULL_HOUSE;
        }
        else if ( counter.isFlush() ) {
            return PokerHands.FLUSH;
        }
        else if ( counter.isStraight() ) {
            return PokerHands.STRAIGHT;
        }
        else if ( counter.numberThrees() == 1 ) {
            return PokerHands.THREE;
        }
        else if ( counter.numberPairs() == 2 ) {
            return PokerHands.TWO_PAIR;
        }
        else if ( counter.numberPairs() == 1 ) {
            return PokerHands.PAIR;
        }
        else if ( counter.numberSingles() == 5 ) {
            return PokerHands.HIGH;
        }
        else {
            throw new UnsupportedOperationException("Poker hand evaluation failed");
        }
    }
    
    public PokerHands handType() {
        return handType;
    }
}
