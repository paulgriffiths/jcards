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
package CardListTests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class ExchangeTest {
    private CardList list;
    
    public ExchangeTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
        list.add(new Card(Ranks.JACK, Suits.HEARTS));
        list.add(new Card(Ranks.QUEEN, Suits.HEARTS));
        list.add(new Card(Ranks.KING, Suits.HEARTS));
    }
    
    @Test
    public void exchangeAtBeginning() {
        final Card c = list.exchange(0, new Card(Ranks.FIVE, Suits.CLUBS));
        assertEquals(new Card(Ranks.JACK, Suits.HEARTS), c);
        assertEquals("[5C,QH,KH]", list.toString());
    }
    
    @Test
    public void exchangeAtMiddle() {
        final Card c = list.exchange(1, new Card(Ranks.FIVE, Suits.CLUBS));
        assertEquals(new Card(Ranks.QUEEN, Suits.HEARTS), c);
        assertEquals("[JH,5C,KH]", list.toString());
    }
    
    @Test
    public void exchangeAtEnd() {
        final Card c = list.exchange(2, new Card(Ranks.FIVE, Suits.CLUBS));
        assertEquals(new Card(Ranks.KING, Suits.HEARTS), c);
        assertEquals("[JH,QH,5C]", list.toString());
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void exchangeBeforeBeginning() {
        final Card c = list.exchange(-1, new Card(Ranks.FIVE, Suits.CLUBS));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void exchangeAfterEnd() {
        final Card c = list.exchange(3, new Card(Ranks.FIVE, Suits.CLUBS));
    }
}
