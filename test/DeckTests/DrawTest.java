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
package DeckTests;

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class DrawTest {
    
    public DrawTest() {
    }
    
    @Test
    public void testDrawSingleCard() {
        Deck deck = new Deck();
        assertEquals(Card.TWO_CLUBS, deck.drawCard());
        assertEquals(51, deck.size());
    }
    
    @Test
    public void testDrawCardsNone() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(0);
        assertTrue(list.isEmpty());
        assertEquals(52, deck.size());
    }
    
    @Test
    public void testDrawCardsOne() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(1);
        assertEquals(Card.TWO_CLUBS, list.get(0));
        assertEquals(1, list.size());
        assertEquals(51, deck.size());
    }
    
    @Test
    public void testDrawTwoCards() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(2);
        assertEquals(Card.TWO_CLUBS, list.get(0));
        assertEquals(Card.THREE_CLUBS, list.get(1));
        assertEquals(2, list.size());
        assertEquals(50, deck.size());
    }
    
    @Test
    public void testDrawFiftyTwoCards() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(52);
        assertEquals(Card.TWO_CLUBS, list.get(0));
        assertEquals(Card.ACE_DIAMONDS, list.get(51));
        assertEquals(52, list.size());
        assertTrue(deck.isEmpty());
    }
    
    @Test(expected=DeckEmptyException.class)
    public void testDrawFiftyThreeCards() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(53);
        fail("exception not thrown");
    }
}
