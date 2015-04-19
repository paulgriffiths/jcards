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
public class StraightTypeTest {
    private static final PokerHand almostStraightFlush = new PokerHand(Card.KING_CLUBS,
                                                                       Card.QUEEN_CLUBS,
                                                                       Card.JACK_SPADES,
                                                                       Card.TEN_CLUBS,
                                                                       Card.NINE_CLUBS);
    private static final PokerHand almostWheelStraightFlush = new PokerHand(Card.ACE_CLUBS,
                                                                            Card.FIVE_CLUBS,
                                                                            Card.FOUR_SPADES,
                                                                            Card.TWO_CLUBS,
                                                                            Card.THREE_CLUBS);
    private static final PokerHand straightKingHigh = new PokerHand(Card.KING_CLUBS,
                                                                    Card.QUEEN_HEARTS,
                                                                    Card.JACK_SPADES,
                                                                    Card.TEN_DIAMONDS,
                                                                    Card.NINE_CLUBS);
    private static final PokerHand straightEightHigh = new PokerHand(Card.SIX_CLUBS,
                                                                     Card.FOUR_HEARTS,
                                                                     Card.EIGHT_SPADES,
                                                                     Card.FIVE_DIAMONDS,
                                                                     Card.SEVEN_CLUBS);
    private static final PokerHand wheelStraight = new PokerHand(Card.TWO_CLUBS,
                                                                 Card.FOUR_HEARTS,
                                                                 Card.THREE_SPADES,
                                                                 Card.ACE_DIAMONDS,
                                                                 Card.FIVE_CLUBS);
    
    public StraightTypeTest() {
    }
    
    @Test
    public void testAlmostStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostStraightFlush);
        assertEquals(PokerHands.STRAIGHT, pe.handType());
    }
    @Test
    public void testAlmostWheelStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostWheelStraightFlush);
        assertEquals(PokerHands.STRAIGHT, pe.handType());
    }
    
    @Test
    public void testStraightKingHigh() {
        PokerHandEvaluator pe = new PokerHandEvaluator(straightKingHigh);
        assertEquals(PokerHands.STRAIGHT, pe.handType());
    }
    
    @Test
    public void testStraightEightHigh() {
        PokerHandEvaluator pe = new PokerHandEvaluator(straightEightHigh);
        assertEquals(PokerHands.STRAIGHT, pe.handType());
    }
    
    @Test
    public void testWheelStraight() {
        PokerHandEvaluator pe = new PokerHandEvaluator(wheelStraight);
        assertEquals(PokerHands.STRAIGHT, pe.handType());
    }
    
}
