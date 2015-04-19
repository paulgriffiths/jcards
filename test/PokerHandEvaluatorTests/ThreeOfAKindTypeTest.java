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
public class ThreeOfAKindTypeTest {
    private static final PokerHand threeSixes = new PokerHand(Card.THREE_CLUBS,
                                                              Card.SIX_CLUBS,
                                                              Card.SIX_DIAMONDS,
                                                              Card.SIX_SPADES,
                                                              Card.KING_HEARTS);
    private static final PokerHand threeTens = new PokerHand(Card.FIVE_CLUBS,
                                                             Card.ACE_HEARTS,
                                                             Card.TEN_SPADES,
                                                             Card.TEN_DIAMONDS,
                                                             Card.TEN_HEARTS);
    
    public ThreeOfAKindTypeTest() {
    }
    
    @Test
    public void testThreeSixes() {
        PokerHandEvaluator pe = new PokerHandEvaluator(threeSixes);
        assertEquals(PokerHands.THREE, pe.handType());
    }
    
    @Test
    public void testThreeTens() {
        PokerHandEvaluator pe = new PokerHandEvaluator(threeTens);
        assertEquals(PokerHands.THREE, pe.handType());
    }
}
