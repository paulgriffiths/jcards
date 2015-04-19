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
public class FourOfAKindComparisonTest {
     
    public FourOfAKindComparisonTest() {
    }
    
    @Test
    public void testCompareFourAllSame() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_SPADES);
        PokerHand p2 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.matches(e2));
    }
    
    @Test
    public void testCompareFourFourHigherSpareSame() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_SPADES);
        PokerHand p2 = new PokerHand(Card.TEN_CLUBS, Card.TEN_HEARTS,
            Card.TEN_SPADES, Card.TEN_DIAMONDS, Card.SEVEN_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFourFourHigherSpareLower() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_SPADES);
        PokerHand p2 = new PokerHand(Card.TEN_CLUBS, Card.TEN_HEARTS,
            Card.TEN_SPADES, Card.TEN_DIAMONDS, Card.SIX_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFourFourHigherSpareHigher() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_SPADES);
        PokerHand p2 = new PokerHand(Card.TEN_CLUBS, Card.TEN_HEARTS,
            Card.TEN_SPADES, Card.TEN_DIAMONDS, Card.KING_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFourFourSameSpareHigher() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SEVEN_SPADES);
        PokerHand p2 = new PokerHand(Card.JACK_CLUBS, Card.JACK_HEARTS,
            Card.JACK_SPADES, Card.JACK_DIAMONDS, Card.SIX_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
}
