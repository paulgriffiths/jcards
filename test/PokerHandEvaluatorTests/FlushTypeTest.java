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
public class FlushTypeTest {
    private static final PokerHand clubsFlush = new PokerHand(Card.QUEEN_CLUBS,
                                                              Card.TEN_CLUBS,
                                                              Card.EIGHT_CLUBS,
                                                              Card.SEVEN_CLUBS,
                                                              Card.TWO_CLUBS);
    private static final PokerHand spadesFlush = new PokerHand(Card.KING_SPADES,
                                                               Card.NINE_SPADES,
                                                               Card.EIGHT_SPADES,
                                                               Card.FOUR_SPADES,
                                                               Card.THREE_SPADES);
    private static final PokerHand almostStraightFlush = new PokerHand(Card.KING_SPADES,
                                                                       Card.QUEEN_SPADES,
                                                                       Card.JACK_SPADES,
                                                                       Card.TEN_SPADES,
                                                                       Card.EIGHT_SPADES);
    private static final PokerHand almostWheelStraightFlush = new PokerHand(Card.SIX_DIAMONDS,
                                                                            Card.FOUR_DIAMONDS,
                                                                            Card.ACE_DIAMONDS,
                                                                            Card.THREE_DIAMONDS,
                                                                            Card.TWO_DIAMONDS);
    
    public FlushTypeTest() {
    }
    
    @Test
    public void testClubsFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(clubsFlush);
        assertEquals(PokerHands.FLUSH, pe.handType());
    }
    
    @Test
    public void testSpadesFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(spadesFlush);
        assertEquals(PokerHands.FLUSH, pe.handType());
    }
    
    @Test
    public void testAlmostStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostStraightFlush);
        assertEquals(PokerHands.FLUSH, pe.handType());
    }
    
    @Test
    public void testAlmostWheelStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostWheelStraightFlush);
        assertEquals(PokerHands.FLUSH, pe.handType());
    }
}
