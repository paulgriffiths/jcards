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
public class AddIndexTest {
    private CardList list;
    
    public AddIndexTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
        list.add(new Card(Ranks.TWO, Suits.CLUBS));
        list.add(new Card(Ranks.THREE, Suits.CLUBS));
        list.add(new Card(Ranks.FOUR, Suits.CLUBS));
        list.add(new Card(Ranks.FIVE, Suits.CLUBS));
        list.add(new Card(Ranks.SIX, Suits.CLUBS));
    }
    
    @Test
    public void testAddAtBeginning() {
        list.add(0, new Card(Ranks.ACE, Suits.HEARTS));
        assertEquals("[AH,2C,3C,4C,5C,6C]", list.toString());
    }
    
    @Test
    public void testAddInMiddle() {
        list.add(2, new Card(Ranks.ACE, Suits.HEARTS));
        assertEquals("[2C,3C,AH,4C,5C,6C]", list.toString());
    }
    
    @Test
    public void testAddBeforeEnd() {
        list.add(4, new Card(Ranks.ACE, Suits.HEARTS));
        assertEquals("[2C,3C,4C,5C,AH,6C]", list.toString());
    }
    
    @Test
    public void testAddAtEnd() {
        list.add(5, new Card(Ranks.ACE, Suits.HEARTS));
        assertEquals("[2C,3C,4C,5C,6C,AH]", list.toString());
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddAfterEnd() {
        list.add(6, new Card(Ranks.ACE, Suits.HEARTS));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddBeforeBeginning() {
        list.add(-1, new Card(Ranks.ACE, Suits.HEARTS));
    }
}
