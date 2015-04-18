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

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class AddTest {
    private CardList list;
    
    public AddTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
    }
    
    @Test
    public void testAddSingleItemSize() {
        list.add(new Card(Ranks.QUEEN, Suits.HEARTS));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }
    
    @Test
    public void testAddSingleItemContains() {
        list.add(new Card(Ranks.QUEEN, Suits.HEARTS));
        assertTrue(list.contains(new Card(Ranks.QUEEN, Suits.HEARTS)));
    }
    
    @Test
    public void testAddSingleItemDoesntContain() {
        list.add(new Card(Ranks.QUEEN, Suits.HEARTS));
        assertFalse(list.contains(new Card(Ranks.QUEEN, Suits.CLUBS)));
    }
    
    @Test
    public void testAddTwoItemsSize() {
        list.add(new Card(Ranks.THREE, Suits.DIAMONDS));
        list.add(new Card(Ranks.JACK, Suits.CLUBS));
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
    }
    
    @Test
    public void testAddTwoItemsContains() {
        list.add(new Card(Ranks.THREE, Suits.DIAMONDS));
        list.add(new Card(Ranks.JACK, Suits.CLUBS));
        assertTrue(list.contains(new Card(Ranks.THREE, Suits.DIAMONDS)));
        assertTrue(list.contains(new Card(Ranks.JACK, Suits.CLUBS)));
    }
}
