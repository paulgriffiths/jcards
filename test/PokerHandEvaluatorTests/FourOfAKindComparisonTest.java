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
public class FourOfAKindComparisonTest {
    
    private static final PokerHand fourEightQueenHigh = new PokerHand(
        Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
        Card.EIGHT_SPADES, Card.QUEEN_HEARTS); 
    private static final PokerHand fourEightSevenHighFirst = new PokerHand(
        Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
        Card.EIGHT_SPADES, Card.SEVEN_SPADES); 
    private static final PokerHand fourEightSevenHighSecond = new PokerHand(
        Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
        Card.EIGHT_SPADES, Card.SEVEN_CLUBS); 
    private static final PokerHand fourEightThreeHigh = new PokerHand(
        Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS,
        Card.EIGHT_SPADES, Card.THREE_DIAMONDS);
    private static final PokerHand fourJack = new PokerHand(
        Card.JACK_CLUBS, Card.JACK_DIAMONDS, Card.JACK_HEARTS,
        Card.JACK_SPADES, Card.TWO_DIAMONDS);
    private static final PokerHand fourThree = new PokerHand(
        Card.THREE_CLUBS, Card.THREE_DIAMONDS, Card.THREE_HEARTS,
        Card.THREE_SPADES, Card.KING_SPADES);
    
    private static final PokerHandEvaluator eFEQH = new PokerHandEvaluator(fourEightQueenHigh);
    private static final PokerHandEvaluator eFE7H1 = new PokerHandEvaluator(fourEightSevenHighFirst);
    private static final PokerHandEvaluator eFE7H2 = new PokerHandEvaluator(fourEightSevenHighSecond);
    private static final PokerHandEvaluator eFE3H = new PokerHandEvaluator(fourEightThreeHigh);
    private static final PokerHandEvaluator eFJ = new PokerHandEvaluator(fourJack);
    private static final PokerHandEvaluator eF3 = new PokerHandEvaluator(fourThree);
    
    public FourOfAKindComparisonTest() {
    }
    
    @Test
    public void testMatches() {
        assertFalse(eFE7H1.matches(eFEQH));
        assertTrue(eFE7H1.matches(eFE7H1));
        assertTrue(eFE7H1.matches(eFE7H2));
        assertFalse(eFE7H1.matches(eFJ));
        assertFalse(eFE7H1.matches(eF3));
        assertFalse(eFEQH.matches(eFJ));
        assertFalse(eFEQH.matches(eF3));
        assertFalse(eFJ.matches(eF3));
    }
    
    @Test
    public void testBeats() {
        assertFalse(eFJ.beats(eFJ));
        assertTrue(eFJ.beats(eFEQH));
        assertTrue(eFJ.beats(eFE7H1));
        assertTrue(eFJ.beats(eFE3H));
        assertTrue(eFJ.beats(eF3));
        assertFalse(eFEQH.beats(eFJ));
        assertFalse(eFEQH.beats(eFEQH));
        assertTrue(eFEQH.beats(eFE7H1));
        assertTrue(eFEQH.beats(eFE3H));
        assertTrue(eFEQH.beats(eF3));
        assertFalse(eFE7H1.beats(eFJ));
        assertFalse(eFE7H1.beats(eFEQH));
        assertFalse(eFE7H1.beats(eFE7H1));
        assertFalse(eFE7H1.beats(eFE7H2));
        assertTrue(eFE7H1.beats(eFE3H));
        assertTrue(eFE7H1.beats(eF3));
        
        
    }
}
