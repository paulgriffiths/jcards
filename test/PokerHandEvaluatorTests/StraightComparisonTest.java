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

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;
import net.paulgriffiths.pcards.poker.*;

/**
 *
 * @author paul
 */
public class StraightComparisonTest {
    
    public StraightComparisonTest() {
    }
    
    @Test
    public void testCompareStraightDifferentNormal() {
        PokerHand p1 = new PokerHand(Card.TEN_CLUBS, Card.NINE_DIAMONDS,
            Card.EIGHT_HEARTS, Card.SEVEN_SPADES, Card.SIX_CLUBS);
        PokerHand p2 = new PokerHand(Card.EIGHT_DIAMONDS, Card.SEVEN_HEARTS,
            Card.SIX_SPADES, Card.FIVE_CLUBS, Card.FOUR_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT, e1.handType());
        assertEquals(PokerHands.STRAIGHT, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareStraightDifferentWheel() {
        PokerHand p1 = new PokerHand(Card.TEN_CLUBS, Card.NINE_DIAMONDS,
            Card.EIGHT_HEARTS, Card.SEVEN_SPADES, Card.SIX_CLUBS);
        PokerHand p2 = new PokerHand(Card.FIVE_DIAMONDS, Card.FOUR_HEARTS,
            Card.THREE_SPADES, Card.TWO_CLUBS, Card.ACE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT, e1.handType());
        assertEquals(PokerHands.STRAIGHT, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareStraightSame() {
        PokerHand p1 = new PokerHand(Card.TEN_CLUBS, Card.NINE_DIAMONDS,
            Card.EIGHT_HEARTS, Card.SEVEN_SPADES, Card.SIX_CLUBS);
        PokerHand p2 = new PokerHand(Card.TEN_DIAMONDS, Card.NINE_HEARTS,
            Card.EIGHT_SPADES, Card.SEVEN_CLUBS, Card.SIX_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT, e1.handType());
        assertEquals(PokerHands.STRAIGHT, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
