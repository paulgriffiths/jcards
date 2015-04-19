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

/**
 *
 * @author paul
 */
public class TwoPairComparisonTest {
    
    public TwoPairComparisonTest() {
    }
    
    @Test
    public void testBothPairsHigher() {
        PokerHand p1 = new PokerHand(Card.NINE_CLUBS, Card.NINE_DIAMONDS,
            Card.SIX_HEARTS, Card.SIX_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
            Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.KING_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFirstPairHigher() {
        PokerHand p1 = new PokerHand(Card.NINE_CLUBS, Card.NINE_DIAMONDS,
            Card.SIX_HEARTS, Card.SIX_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
            Card.SIX_SPADES, Card.SIX_CLUBS, Card.KING_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testSecondPairHigher() {
        PokerHand p1 = new PokerHand(Card.NINE_CLUBS, Card.NINE_DIAMONDS,
            Card.SIX_HEARTS, Card.SIX_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.NINE_DIAMONDS, Card.NINE_HEARTS,
            Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.KING_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testPairsSameSingleDifferent() {
        PokerHand p1 = new PokerHand(Card.NINE_CLUBS, Card.NINE_DIAMONDS,
            Card.SIX_HEARTS, Card.SIX_SPADES, Card.ACE_CLUBS);
        PokerHand p2 = new PokerHand(Card.NINE_DIAMONDS, Card.NINE_HEARTS,
            Card.SIX_SPADES, Card.SIX_CLUBS, Card.KING_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testPairsSameSingleSame() {
        PokerHand p1 = new PokerHand(Card.NINE_CLUBS, Card.NINE_DIAMONDS,
            Card.SIX_HEARTS, Card.SIX_SPADES, Card.ACE_CLUBS);
        PokerHand p2 = new PokerHand(Card.NINE_DIAMONDS, Card.NINE_HEARTS,
            Card.SIX_SPADES, Card.SIX_CLUBS, Card.ACE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
