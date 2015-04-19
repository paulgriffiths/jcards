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
public class ScoringTest {
    private static final PokerHandEvaluator high = new PokerHandEvaluator(
        new PokerHand(Card.EIGHT_CLUBS, Card.EIGHT_DIAMONDS,
                      Card.FIVE_HEARTS, Card.FIVE_SPADES,
                      Card.KING_SPADES));
    private static final PokerHandEvaluator midOne = new PokerHandEvaluator(
        new PokerHand(Card.SEVEN_CLUBS, Card.SEVEN_DIAMONDS,
                      Card.FIVE_HEARTS, Card.FIVE_SPADES,
                      Card.KING_SPADES));
    private static final PokerHandEvaluator midTwo = new PokerHandEvaluator(
        new PokerHand(Card.SEVEN_HEARTS, Card.SEVEN_DIAMONDS,
                      Card.FIVE_SPADES, Card.FIVE_CLUBS,
                      Card.KING_CLUBS));
    private static final PokerHandEvaluator low = new PokerHandEvaluator(
        new PokerHand(Card.SIX_CLUBS, Card.SIX_DIAMONDS,
                      Card.FIVE_HEARTS, Card.FIVE_SPADES,
                      Card.KING_SPADES));
    
    public ScoringTest() {
    }
    
    @Test
    public void testMatchesSelfTrue() {
        assertTrue(high.matches(high));
    }
    
    @Test
    public void testBeatsSelfFalse() {
        assertFalse(high.beats(high));
    }
    
    @Test
    public void testLosesToSelfFalse() {
        assertFalse(high.losesTo(high));
    }
    
    @Test
    public void testHighBeatsLowTrue() {
        assertTrue(high.beats(low));
    }
    
    @Test
    public void testHighLosesToLowFalse() {
        assertFalse(high.losesTo(low));
    }
    
    @Test
    public void testHighMatchesLowFalse() {
        assertFalse(high.matches(low));
    }
    
    @Test
    public void testLowLosesToHighTrue() {
        assertTrue(low.losesTo(high));
    }
    
    @Test
    public void testLowBeatsHighFalse() {
        assertFalse(low.beats(high));
    }
    
    @Test
    public void testLowMatchesHighFalse() {
        assertFalse(low.matches(high));
    }

    @Test
    public void testMidMatchesTrue() {
        assertTrue(midOne.matches(midTwo));
    }
    
    @Test
    public void testMidBeatsFalse() {
        assertFalse(midOne.beats(midTwo));
    }
    
    @Test
    public void testMidLosesToFalse() {
        assertFalse(midOne.losesTo(midTwo));
    }
    
}
