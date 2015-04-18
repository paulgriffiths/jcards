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
public class GetTest {
    private CardList list;
    
    public GetTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
        list.add(new Card(Ranks.TEN, Suits.CLUBS));
        list.add(new Card(Ranks.JACK, Suits.CLUBS));
        list.add(new Card(Ranks.QUEEN, Suits.CLUBS));
    }
    
    @Test
    public void testGetAtBeginning() {
        assertEquals(new Card(Ranks.TEN, Suits.CLUBS), list.get(0));
    }
    
    @Test
    public void testGetAtMiddle() {
        assertEquals(new Card(Ranks.JACK, Suits.CLUBS), list.get(1));
    }
    
    @Test
    public void testGetAtEnd() {
        assertEquals(new Card(Ranks.QUEEN, Suits.CLUBS), list.get(2));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetBeforeBeginning() {
        assertEquals(new Card(Ranks.NINE, Suits.CLUBS), list.get(-1));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetAfterEnd() {
        assertEquals(new Card(Ranks.KING, Suits.CLUBS), list.get(3));
    }
}
