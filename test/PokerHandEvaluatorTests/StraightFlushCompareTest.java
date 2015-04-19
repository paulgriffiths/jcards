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
public class StraightFlushCompareTest {
    private static final PokerHand sf9First = new PokerHand(Card.NINE_DIAMONDS,
        Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS, Card.SIX_DIAMONDS,
        Card.FIVE_DIAMONDS);
    private static final PokerHand sf9Second = new PokerHand(Card.NINE_HEARTS,
        Card.EIGHT_HEARTS, Card.SEVEN_HEARTS, Card.SIX_HEARTS,
        Card.FIVE_HEARTS);
    private static final PokerHand sfQueen = new PokerHand(Card.QUEEN_SPADES,
        Card.JACK_SPADES, Card.TEN_SPADES, Card.NINE_SPADES,
        Card.EIGHT_SPADES);
    private static final PokerHand sfFive = new PokerHand(Card.FIVE_CLUBS,
        Card.FOUR_CLUBS, Card.THREE_CLUBS, Card.TWO_CLUBS,
        Card.ACE_CLUBS);
    
    private static final PokerHandEvaluator e9First = new PokerHandEvaluator(sf9First);
    private static final PokerHandEvaluator e9Second = new PokerHandEvaluator(sf9Second);
    private static final PokerHandEvaluator eQueen = new PokerHandEvaluator(sfQueen);
    private static final PokerHandEvaluator eFive = new PokerHandEvaluator(sfFive);
    
    
    public StraightFlushCompareTest() {
    }
    
    @Test
    public void testMatches() {
        assertTrue(e9First.matches(e9First));
        assertTrue(e9First.matches(e9Second));
        assertFalse(e9First.matches(eQueen));
        assertFalse(e9First.matches(eFive));
        assertTrue(e9Second.matches(e9Second));
        assertTrue(e9Second.matches(e9First));
        assertFalse(e9Second.matches(eQueen));
        assertFalse(e9Second.matches(eFive));
        assertTrue(eQueen.matches(eQueen));
        assertFalse(eQueen.matches(e9First));
        assertFalse(eQueen.matches(e9Second));
        assertFalse(eQueen.matches(eFive));
        assertTrue(eFive.matches(eFive));
        assertFalse(eFive.matches(e9First));
        assertFalse(eFive.matches(e9Second));
        assertFalse(eFive.matches(eQueen));
    }
    
    @Test
    public void testBeats() {
        assertFalse(eQueen.beats(eQueen));
        assertTrue(eQueen.beats(e9First));
        assertTrue(eQueen.beats(eFive));
        assertFalse(e9First.beats(eQueen));
        assertFalse(e9First.beats(e9First));
        assertFalse(e9First.beats(e9Second));
        assertTrue(e9First.beats(eFive));
        assertFalse(eFive.beats(eQueen));
        assertFalse(eFive.beats(e9First));
        assertFalse(eFive.beats(eFive));
    }
    
    @Test
    public void testLosesTo() {
        assertFalse(eQueen.losesTo(eQueen));
        assertFalse(eQueen.losesTo(e9First));
        assertFalse(eQueen.losesTo(eFive));
        assertTrue(e9First.losesTo(eQueen));
        assertFalse(e9First.losesTo(e9First));
        assertFalse(e9First.losesTo(e9Second));
        assertFalse(e9First.losesTo(eFive));
        assertTrue(eFive.losesTo(eQueen));
        assertTrue(eFive.losesTo(e9First));
        assertFalse(eFive.losesTo(eFive));
    }
}
