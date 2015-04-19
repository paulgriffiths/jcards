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
public class ThreeOfAKindComparisonTest {
    
    public ThreeOfAKindComparisonTest() {
    }
    
    @Test
    public void testThreesDifferent() {
        PokerHand p1 = new PokerHand(Card.QUEEN_CLUBS, Card.QUEEN_DIAMONDS,
            Card.QUEEN_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.FOUR_DIAMONDS, Card.FOUR_HEARTS,
            Card.FOUR_SPADES, Card.KING_CLUBS, Card.ACE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreesSameFirstSingleDifferent() {
        PokerHand p1 = new PokerHand(Card.QUEEN_CLUBS, Card.QUEEN_DIAMONDS,
            Card.QUEEN_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.QUEEN_DIAMONDS, Card.QUEEN_HEARTS,
            Card.QUEEN_SPADES, Card.SIX_CLUBS, Card.THREE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreesSameSecondSingleDifferent() {
        PokerHand p1 = new PokerHand(Card.QUEEN_CLUBS, Card.QUEEN_DIAMONDS,
            Card.QUEEN_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.QUEEN_DIAMONDS, Card.QUEEN_HEARTS,
            Card.QUEEN_SPADES, Card.SEVEN_CLUBS, Card.TWO_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreesSameBothSinglesDifferent() {
        PokerHand p1 = new PokerHand(Card.QUEEN_CLUBS, Card.QUEEN_DIAMONDS,
            Card.QUEEN_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.QUEEN_DIAMONDS, Card.QUEEN_HEARTS,
            Card.QUEEN_SPADES, Card.SIX_CLUBS, Card.TWO_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreesSameBothSinglesSame() {
        PokerHand p1 = new PokerHand(Card.QUEEN_CLUBS, Card.QUEEN_DIAMONDS,
            Card.QUEEN_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.QUEEN_DIAMONDS, Card.QUEEN_HEARTS,
            Card.QUEEN_SPADES, Card.SEVEN_CLUBS, Card.THREE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
