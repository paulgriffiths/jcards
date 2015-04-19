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
public class StraightFlushTypeTest {
    private static final PokerHand straightFlush = new PokerHand(Card.NINE_CLUBS,
                                                                 Card.KING_CLUBS,
                                                                 Card.QUEEN_CLUBS,
                                                                 Card.JACK_CLUBS,
                                                                 Card.TEN_CLUBS);
    private static final PokerHand wheelFlush = new PokerHand(Card.THREE_HEARTS,
                                                              Card.FOUR_HEARTS,
                                                              Card.ACE_HEARTS,
                                                              Card.FIVE_HEARTS,
                                                              Card.TWO_HEARTS);
    
    public StraightFlushTypeTest() {
    }
    
    @Test
    public void testStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(straightFlush);
        assertEquals(PokerHands.STRAIGHT_FLUSH, pe.handType());
    }
    
    @Test
    public void testWheelFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(wheelFlush);
        assertEquals(PokerHands.STRAIGHT_FLUSH, pe.handType());
    }
}
