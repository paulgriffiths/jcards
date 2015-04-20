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
package HandTests;

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class ConstructorTest {
    
    public ConstructorTest() {
    }
    
    @Test
    public void testDefaultConstructor() {
        Hand hand = new Hand();
        assertTrue(hand.isEmpty());
        assertEquals("[]", hand.toString());
    }
    
    @Test
    public void testCardConstructorSingleCard() {
        Hand hand = new Hand(Card.NINE_SPADES);
        assertEquals(1, hand.size());
        assertFalse(hand.isEmpty());
        assertEquals("[9S]", hand.toString());
    }
    
    @Test
    public void testCardConstructorTwoCards() {
        Hand hand = new Hand(Card.NINE_SPADES, Card.FIVE_CLUBS);
        assertEquals(2, hand.size());
        assertEquals("[9S,5C]", hand.toString());
    }
    
    @Test
    public void testCardConstructorThreeCards() {
        Hand hand = new Hand(Card.NINE_SPADES, Card.FIVE_CLUBS, Card.JACK_HEARTS);
        assertEquals(3, hand.size());
        assertEquals("[9S,5C,JH]", hand.toString());
    }
    
    @Test
    public void testCardListConstructorEmpty() {
        Hand hand = new Hand(new CardList());
        assertTrue(hand.isEmpty());
        assertEquals("[]", hand.toString());
    }
    
    @Test
    public void testCardListConstructorNotEmpty() {
        Hand hand = new Hand(new CardList(Card.FOUR_DIAMONDS, Card.SIX_SPADES));
        assertEquals(2, hand.size());
        assertEquals("[4D,6S]", hand.toString());
    }
    
    @Test
    public void testDeckConstructor() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck, 3);
        assertEquals(3, hand.size());
        assertEquals(49, deck.size());
        assertEquals("[2C,3C,4C]", hand.toString());
    }
}
