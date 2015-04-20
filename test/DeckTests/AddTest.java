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
public class AddTest {
    
    public AddTest() {
    }
 
    @Test
    public void testAddSingleCard() {
        Deck deck = new Deck();
        deck.addCard(Card.SEVEN_DIAMONDS);
        assertEquals(0, deck.discardsSize());
        assertEquals(53, deck.size());
        
        CardList list = deck.drawCards(53);
        assertEquals(Card.SEVEN_DIAMONDS, list.get(52));
    }
    
    @Test
    public void testAddTwoCards() {
        Deck deck = new Deck();
        deck.addCards(new CardList(Card.SEVEN_DIAMONDS, Card.TWO_HEARTS));
        assertEquals(0, deck.discardsSize());
        assertEquals(54, deck.size());
        
        CardList list = deck.drawCards(54);
        assertEquals(Card.SEVEN_DIAMONDS, list.get(52));
        assertEquals(Card.TWO_HEARTS, list.get(53));
    }
    
}
