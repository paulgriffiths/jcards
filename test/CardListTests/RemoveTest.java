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
public class RemoveTest {
    private CardList list;
    
    public RemoveTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
        list.add(new Card(Ranks.ACE, Suits.SPADES));
        list.add(new Card(Ranks.TWO, Suits.SPADES));
        list.add(new Card(Ranks.THREE, Suits.SPADES));
    }
    
    @Test
    public void testRemoveAtBeginning() {
        assertTrue(list.remove(new Card(Ranks.ACE, Suits.SPADES)));
        assertEquals("[2S,3S]", list.toString());
    }
    
    @Test
    public void testRemoveAtMiddle() {
        assertTrue(list.remove(new Card(Ranks.TWO, Suits.SPADES)));
        assertEquals("[AS,3S]", list.toString());
    }
    
    @Test
    public void testRemoveAtEnd() {
        assertTrue(list.remove(new Card(Ranks.THREE, Suits.SPADES)));
        assertEquals("[AS,2S]", list.toString());
    }
    
    @Test
    public void testRemoveElementNotPresent() {
        assertFalse(list.remove(new Card(Ranks.FOUR, Suits.SPADES)));
    }
}
