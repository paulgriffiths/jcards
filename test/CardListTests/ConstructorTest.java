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
    public void testDefaultConstructorYieldsEmptyList() {
        CardList list = new CardList();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void testCopyConstructor() {
        CardList list1 = new CardList();
        list1.add(new Card(Ranks.NINE, Suits.CLUBS));
        list1.add(new Card(Ranks.TEN, Suits.CLUBS));
        list1.add(new Card(Ranks.JACK, Suits.CLUBS));
        
        //  Test list is copied
        
        CardList list2 = new CardList(list1);
        assertEquals("[9C,TC,JC]", list1.toString());
        assertEquals("[9C,TC,JC]", list2.toString());
        
        //  Test that an actual new list was created
        
        list1.exchange(1, new Card(Ranks.THREE, Suits.HEARTS));
        assertEquals("[9C,3H,JC]", list1.toString());
        assertEquals("[9C,TC,JC]", list2.toString());
    }
    
    @Test
    public void testCardConstructorSingle() {
        CardList list = new CardList(Card.THREE_HEARTS);
        assertEquals("[3H]", list.toString());
    }
    
    @Test
    public void testCardConstructorMultiple() {
        CardList list = new CardList(Card.THREE_HEARTS, Card.TEN_SPADES,
                                     Card.JACK_CLUBS, Card.ACE_DIAMONDS);
        assertEquals("[3H,TS,JC,AD]", list.toString());
    }
}
