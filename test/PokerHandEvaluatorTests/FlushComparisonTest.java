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
public class FlushComparisonTest {
    
    public FlushComparisonTest() {
    }
    
    @Test
    public void testCompareFlushAllSame() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.JACK_DIAMONDS,
            Card.NINE_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FIVE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.matches(e2));
    }
    
    @Test
    public void testCompareFlushFirstDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.QUEEN_DIAMONDS, Card.JACK_DIAMONDS,
            Card.NINE_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FIVE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFlushSecondDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.TEN_DIAMONDS,
            Card.NINE_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FIVE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFlushThirdDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.JACK_DIAMONDS,
            Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FIVE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFlushFourthDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.JACK_DIAMONDS,
            Card.NINE_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFlushFifthDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.JACK_DIAMONDS,
            Card.NINE_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FOUR_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testCompareFlushThreeCardsDifferent() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.JACK_CLUBS,
            Card.NINE_CLUBS, Card.SEVEN_CLUBS, Card.FIVE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.TEN_DIAMONDS,
            Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS, Card.FOUR_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
}
