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
public class HighCardComparisonTest {
    
    public HighCardComparisonTest() {
    }
    
    @Test
    public void testOneSimilar() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_CLUBS, Card.JACK_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.HIGH, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testTwoSimilar() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.EIGHT_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.HIGH, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreeSimilar() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SIX_SPADES, Card.TWO_CLUBS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.HIGH, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFourSimilar() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.TWO_CLUBS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.HIGH, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFiveSimilar() {
        PokerHand p1 = new PokerHand(Card.KING_CLUBS, Card.QUEEN_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_DIAMONDS, Card.QUEEN_HEARTS,
            Card.NINE_SPADES, Card.SEVEN_CLUBS, Card.THREE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.HIGH, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
