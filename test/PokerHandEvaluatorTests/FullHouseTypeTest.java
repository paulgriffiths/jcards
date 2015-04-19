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
public class FullHouseTypeTest {
    private static final PokerHand queensFullJacks = new PokerHand(Card.QUEEN_CLUBS,
                                                                   Card.QUEEN_HEARTS,
                                                                   Card.QUEEN_SPADES,
                                                                   Card.JACK_DIAMONDS,
                                                                   Card.JACK_CLUBS);
    private static final PokerHand foursFullTens = new PokerHand(Card.FOUR_CLUBS,
                                                                 Card.FOUR_HEARTS,
                                                                 Card.FOUR_SPADES,
                                                                 Card.TEN_DIAMONDS,
                                                                 Card.TEN_CLUBS);
    public FullHouseTypeTest() {
    }
    
    @Test
    public void testQueensFullJacks() {
        PokerHandEvaluator pe = new PokerHandEvaluator(queensFullJacks);
        assertEquals(PokerHands.FULL_HOUSE, pe.handType());
    }
    
    @Test
    public void testFoursFullTens() {
        PokerHandEvaluator pe = new PokerHandEvaluator(foursFullTens);
        assertEquals(PokerHands.FULL_HOUSE, pe.handType());
    }
}
