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
package PokerHandEvaluatorTests;

import net.paulgriffiths.pcards.Card;
import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class StraightFlushComparisonTest {
    
    public StraightFlushComparisonTest() {
    }
    
    @Test
    public void testCompareStraightDifferentNormal() {
        PokerHand p1 = new PokerHand(Card.TEN_CLUBS, Card.NINE_CLUBS,
            Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS);
        PokerHand p2 = new PokerHand(Card.EIGHT_HEARTS, Card.SEVEN_HEARTS,
            Card.SIX_HEARTS, Card.FIVE_HEARTS, Card.FOUR_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT_FLUSH, e1.handType());
        assertEquals(PokerHands.STRAIGHT_FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareStraightDifferentWheel() {
        PokerHand p1 = new PokerHand(Card.TEN_SPADES, Card.NINE_SPADES,
            Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_SPADES);
        PokerHand p2 = new PokerHand(Card.FIVE_DIAMONDS, Card.FOUR_DIAMONDS,
            Card.THREE_DIAMONDS, Card.TWO_DIAMONDS, Card.ACE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT_FLUSH, e1.handType());
        assertEquals(PokerHands.STRAIGHT_FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareStraightSame() {
        PokerHand p1 = new PokerHand(Card.TEN_HEARTS, Card.NINE_HEARTS,
            Card.EIGHT_HEARTS, Card.SEVEN_HEARTS, Card.SIX_HEARTS);
        PokerHand p2 = new PokerHand(Card.TEN_SPADES, Card.NINE_SPADES,
            Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT_FLUSH, e1.handType());
        assertEquals(PokerHands.STRAIGHT_FLUSH, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
