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
import net.paulgriffiths.pcards.poker.*;

/**
 *
 * @author paul
 */
public class RoyalFlushComparisonTest {
    
    public RoyalFlushComparisonTest() {
    }
    
    @Test
    public void testCompareRoyalFlush() {
        PokerHand h1 = new PokerHand(Card.ACE_CLUBS, Card.KING_CLUBS,
                                     Card.QUEEN_CLUBS, Card.JACK_CLUBS,
                                     Card.TEN_CLUBS);
        PokerHand h2 = new PokerHand(Card.ACE_HEARTS, Card.KING_HEARTS,
                                     Card.QUEEN_HEARTS, Card.JACK_HEARTS,
                                     Card.TEN_HEARTS);
        PokerHandEvaluator e1 = new PokerHandEvaluator(h1);
        PokerHandEvaluator e2 = new PokerHandEvaluator(h2);
        assertEquals(PokerHands.ROYAL_FLUSH, e1.handType());
        assertEquals(PokerHands.ROYAL_FLUSH, e2.handType());
        assertTrue(e1.matches(e2));
    }
}
