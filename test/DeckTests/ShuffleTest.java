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
public class ShuffleTest {
    
    public ShuffleTest() {
    }
    
    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        deck.shuffle();
        Card card = deck.drawCard();
        assertFalse(Card.TWO_CLUBS.equals(card));
    }
    
    @Test
    public void testShuffleAfterDiscard() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(5);
        deck.discardCards(list);
        assertEquals(47, deck.size());
        assertEquals(5, deck.discardsSize());
        
        deck.shuffle();
        assertEquals(47, deck.size());
        assertEquals(5, deck.discardsSize());
    }
    
    @Test
    public void testReplaceDiscardsAndShuffle() {
        Deck deck = new Deck();
        CardList list = deck.drawCards(5);
        deck.discardCards(list);
        assertEquals(47, deck.size());
        assertEquals(5, deck.discardsSize());
        
        deck.replaceDiscardsAndShuffle();
        assertEquals(52, deck.size());
        assertEquals(0, deck.discardsSize());
    }
}
