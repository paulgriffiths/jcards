/*
 * Copyright (C) 2015 Paul Griffiths
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
package CardTests;

import org.junit.Test;
import static org.junit.Assert.*;
import net.paulgriffiths.pcards.Card;
import net.paulgriffiths.pcards.Ranks;
import net.paulgriffiths.pcards.Suits;

/**
 *
 * @author paul
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @Test
    public void testConstructor() {
        Card c = new Card(Ranks.ACE, Suits.SPADES);
        assertEquals(Ranks.ACE, c.getRank());
        assertEquals(Suits.SPADES, c.getSuit());
    }
    
    @Test
    public void testToString() {
        assertEquals("AS", new Card(Ranks.ACE, Suits.SPADES).toString());
        assertEquals("2D", new Card(Ranks.TWO, Suits.DIAMONDS).toString());
        assertEquals("3C", new Card(Ranks.THREE, Suits.CLUBS).toString());
        assertEquals("4H", new Card(Ranks.FOUR, Suits.HEARTS).toString());
        assertEquals("5S", new Card(Ranks.FIVE, Suits.SPADES).toString());
        assertEquals("6D", new Card(Ranks.SIX, Suits.DIAMONDS).toString());
        assertEquals("7C", new Card(Ranks.SEVEN, Suits.CLUBS).toString());
        assertEquals("8H", new Card(Ranks.EIGHT, Suits.HEARTS).toString());
        assertEquals("9S", new Card(Ranks.NINE, Suits.SPADES).toString());
        assertEquals("TD", new Card(Ranks.TEN, Suits.DIAMONDS).toString());
        assertEquals("JC", new Card(Ranks.JACK, Suits.CLUBS).toString());
        assertEquals("QH", new Card(Ranks.QUEEN, Suits.HEARTS).toString());
        assertEquals("KS", new Card(Ranks.KING, Suits.SPADES).toString());
    }
}
