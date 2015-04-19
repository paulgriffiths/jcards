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
public class RoyalFlushCompareTest {
    
    public RoyalFlushCompareTest() {
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
        
        assertTrue(e1.matches(e2));
        assertTrue(e2.matches(e1));
        assertTrue(e1.matches(e1));
        assertTrue(e2.matches(e2));
        assertFalse(e1.beats(e2));
        assertFalse(e1.losesTo(e2));
        assertFalse(e2.beats(e1));
        assertFalse(e2.losesTo(e1));
    }
}
