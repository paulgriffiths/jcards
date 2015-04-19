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
public class HandTypesComparisonTest {
    
    public HandTypesComparisonTest() {
    }
    
    @Test
    public void testRoyalFlushBeatsStraightFlush() {
        PokerHand p1 = new PokerHand(Card.ACE_CLUBS, Card.KING_CLUBS,
            Card.QUEEN_CLUBS, Card.JACK_CLUBS, Card.TEN_CLUBS);
        PokerHand p2 = new PokerHand(Card.KING_SPADES, Card.QUEEN_SPADES,
            Card.JACK_SPADES, Card.TEN_SPADES, Card.NINE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.ROYAL_FLUSH, e1.handType());
        assertEquals(PokerHands.STRAIGHT_FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testStraightFlushBeatsFourOfAKind() {
        PokerHand p1 = new PokerHand(Card.KING_SPADES, Card.QUEEN_SPADES,
            Card.JACK_SPADES, Card.TEN_SPADES, Card.NINE_SPADES);
        PokerHand p2 = new PokerHand(Card.ACE_SPADES, Card.ACE_DIAMONDS,
            Card.ACE_HEARTS, Card.ACE_CLUBS, Card.THREE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT_FLUSH, e1.handType());
        assertEquals(PokerHands.FOUR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFourOfAKindBeatsFullHouse() {
        PokerHand p1 = new PokerHand(Card.ACE_SPADES, Card.ACE_DIAMONDS,
            Card.ACE_HEARTS, Card.ACE_CLUBS, Card.THREE_SPADES);
        PokerHand p2 = new PokerHand(Card.ACE_SPADES, Card.ACE_DIAMONDS,
            Card.ACE_HEARTS, Card.THREE_CLUBS, Card.THREE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FOUR, e1.handType());
        assertEquals(PokerHands.FULL_HOUSE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFullHouseBeatsFlush() {
        PokerHand p1 = new PokerHand(Card.ACE_SPADES, Card.ACE_DIAMONDS,
            Card.ACE_HEARTS, Card.THREE_CLUBS, Card.THREE_SPADES);
        PokerHand p2 = new PokerHand(Card.ACE_SPADES, Card.THREE_SPADES,
            Card.FIVE_SPADES, Card.SEVEN_SPADES, Card.NINE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FULL_HOUSE, e1.handType());
        assertEquals(PokerHands.FLUSH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testFlushBeatsStraight() {
        PokerHand p1 = new PokerHand(Card.ACE_SPADES, Card.THREE_SPADES,
            Card.FIVE_SPADES, Card.SEVEN_SPADES, Card.NINE_SPADES);
        PokerHand p2 = new PokerHand(Card.FOUR_SPADES, Card.FIVE_CLUBS,
            Card.SIX_HEARTS, Card.SEVEN_DIAMONDS, Card.EIGHT_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.FLUSH, e1.handType());
        assertEquals(PokerHands.STRAIGHT, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testStraightBeatsThreeOfAKind() {
        PokerHand p1 = new PokerHand(Card.FOUR_SPADES, Card.FIVE_CLUBS,
            Card.SIX_HEARTS, Card.SEVEN_DIAMONDS, Card.EIGHT_SPADES);
        PokerHand p2 = new PokerHand(Card.KING_SPADES, Card.KING_CLUBS,
            Card.KING_HEARTS, Card.FIVE_DIAMONDS, Card.THREE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.STRAIGHT, e1.handType());
        assertEquals(PokerHands.THREE, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testThreeOfAKindBeatsTwoPair() {
        PokerHand p1 = new PokerHand(Card.KING_SPADES, Card.KING_CLUBS,
            Card.KING_HEARTS, Card.FIVE_DIAMONDS, Card.THREE_SPADES);
        PokerHand p2 = new PokerHand(Card.KING_SPADES, Card.KING_CLUBS,
            Card.ACE_HEARTS, Card.ACE_DIAMONDS, Card.THREE_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.THREE, e1.handType());
        assertEquals(PokerHands.TWO_PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testTwoPairBeatsPair() {
        PokerHand p1 = new PokerHand(Card.KING_SPADES, Card.KING_CLUBS,
            Card.QUEEN_HEARTS, Card.QUEEN_DIAMONDS, Card.THREE_SPADES);
        PokerHand p2 = new PokerHand(Card.JACK_SPADES, Card.KING_CLUBS,
            Card.ACE_HEARTS, Card.ACE_DIAMONDS, Card.FOUR_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.TWO_PAIR, e1.handType());
        assertEquals(PokerHands.PAIR, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
    
    @Test
    public void testPairBeatsHighCard() {
        PokerHand p1 = new PokerHand(Card.TWO_SPADES, Card.THREE_CLUBS,
            Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.FOUR_SPADES);
        PokerHand p2 = new PokerHand(Card.JACK_SPADES, Card.KING_CLUBS,
            Card.ACE_HEARTS, Card.FIVE_DIAMONDS, Card.FOUR_SPADES);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertEquals(PokerHands.PAIR, e1.handType());
        assertEquals(PokerHands.HIGH, e2.handType());
        assertTrue(e1.beats(e2));
        assertTrue(e2.losesTo(e1));
    }
}
