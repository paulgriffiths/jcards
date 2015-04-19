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
public class PairComparisonTest {
    
    public PairComparisonTest() {
    }
    
    @Test
    public void testPairsDifferent() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.TEN_DIAMONDS, Card.TEN_HEARTS,
            Card.NINE_SPADES, Card.SEVEN_CLUBS, Card.THREE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertTrue(e1.beats(e2));
    }
    
    @Test
    public void testPairsSameOneSimilarSingle() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.JACK_DIAMONDS, Card.JACK_HEARTS,
            Card.NINE_SPADES, Card.SIX_CLUBS, Card.TWO_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertTrue(e1.beats(e2));
    }
    
    @Test
    public void testPairsSameTwoSimilarSingles() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.JACK_DIAMONDS, Card.JACK_HEARTS,
            Card.NINE_SPADES, Card.SEVEN_CLUBS, Card.TWO_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertTrue(e1.beats(e2));
    }
    
    @Test
    public void testPairsSameThreeSimilarSingles() {
        PokerHand p1 = new PokerHand(Card.JACK_CLUBS, Card.JACK_DIAMONDS,
            Card.NINE_HEARTS, Card.SEVEN_SPADES, Card.THREE_CLUBS);
        PokerHand p2 = new PokerHand(Card.JACK_DIAMONDS, Card.JACK_HEARTS,
            Card.NINE_SPADES, Card.SEVEN_CLUBS, Card.THREE_DIAMONDS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(p1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(p2);
        assertTrue(e1.matches(e2));
    }
}
