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
public class TwoPairTypeTest {
    private static final PokerHand twosThrees = new PokerHand(Card.TWO_CLUBS,
                                                              Card.THREE_CLUBS,
                                                              Card.TWO_SPADES,
                                                              Card.SEVEN_HEARTS,
                                                              Card.THREE_DIAMONDS);
    private static final PokerHand acesJacks = new PokerHand(Card.JACK_CLUBS,
                                                             Card.TWO_CLUBS,
                                                             Card.JACK_SPADES,
                                                             Card.ACE_HEARTS,
                                                             Card.ACE_DIAMONDS);
    
    public TwoPairTypeTest() {
    }
    
    @Test
    public void testTwosThrees() {
        PokerHandEvaluator pe = new PokerHandEvaluator(twosThrees);
        assertEquals(PokerHands.TWO_PAIR, pe.handType());
    }
    
    @Test
    public void testAcesJacks() {
        PokerHandEvaluator pe = new PokerHandEvaluator(acesJacks);
        assertEquals(PokerHands.TWO_PAIR, pe.handType());
    }
}
