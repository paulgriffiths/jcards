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
public class FourOfAKindTypeTest {
    private static final PokerHand fourAces = new PokerHand(Card.ACE_CLUBS,
                                                            Card.ACE_HEARTS,
                                                            Card.ACE_SPADES,
                                                            Card.ACE_DIAMONDS,
                                                            Card.FIVE_CLUBS);
    private static final PokerHand fourFives = new PokerHand(Card.FIVE_CLUBS,
                                                             Card.FIVE_HEARTS,
                                                             Card.FIVE_SPADES,
                                                             Card.FIVE_DIAMONDS,
                                                             Card.JACK_SPADES);
    
    public FourOfAKindTypeTest() {
    }
    
    @Test
    public void testFourOfAKindLowSpare() {
        PokerHandEvaluator pe = new PokerHandEvaluator(fourAces);
        assertEquals(PokerHands.FOUR, pe.handType());
    }
    
    @Test
    public void testFourOfAKindHighSpare() {
        PokerHandEvaluator pe = new PokerHandEvaluator(fourFives);
        assertEquals(PokerHands.FOUR, pe.handType());
    }
}
