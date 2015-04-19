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
public class HighCardTypeTest {
    private static final PokerHand almostRoyalFlush = new PokerHand(Card.ACE_CLUBS,
                                                                    Card.KING_CLUBS,
                                                                    Card.QUEEN_CLUBS,
                                                                    Card.JACK_CLUBS,
                                                                    Card.NINE_HEARTS);
    private static final PokerHand almostStraightFlush = new PokerHand(Card.EIGHT_SPADES,
                                                                       Card.KING_SPADES,
                                                                       Card.QUEEN_SPADES,
                                                                       Card.JACK_SPADES,
                                                                       Card.TEN_HEARTS);
    private static final PokerHand almostStraight = new PokerHand(Card.EIGHT_SPADES,
                                                                  Card.SIX_SPADES,
                                                                  Card.FOUR_HEARTS,
                                                                  Card.SEVEN_SPADES,
                                                                  Card.THREE_HEARTS);
    private static final PokerHand almostFlush = new PokerHand(Card.EIGHT_SPADES,
                                                               Card.TWO_SPADES,
                                                               Card.THREE_SPADES,
                                                               Card.SEVEN_SPADES,
                                                               Card.NINE_HEARTS);
    
    public HighCardTypeTest() {
    }
    
    @Test
    public void almostRoyalFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostRoyalFlush);
        assertEquals(PokerHands.HIGH, pe.handType());
    }
    
    @Test
    public void almostStraightFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostStraightFlush);
        assertEquals(PokerHands.HIGH, pe.handType());
    }
    
    @Test
    public void almostStraight() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostStraight);
        assertEquals(PokerHands.HIGH, pe.handType());
    }
    
    @Test
    public void almostFlush() {
        PokerHandEvaluator pe = new PokerHandEvaluator(almostFlush);
        assertEquals(PokerHands.HIGH, pe.handType());
    }
}
