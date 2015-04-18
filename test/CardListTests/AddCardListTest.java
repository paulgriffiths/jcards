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
public class AddCardListTest {
    
    public AddCardListTest() {
    }
    
    @Test
    public void testAddCardList() {
        CardList list1 = new CardList();
        list1.add(new Card(Ranks.ACE, Suits.HEARTS));
        list1.add(new Card(Ranks.TWO, Suits.HEARTS));
        list1.add(new Card(Ranks.THREE, Suits.HEARTS));
        
        CardList list2 = new CardList();
        list2.add(new Card(Ranks.SIX, Suits.DIAMONDS));
        list2.add(new Card(Ranks.SEVEN, Suits.DIAMONDS));
        list2.add(new Card(Ranks.EIGHT, Suits.DIAMONDS));
        
        list1.add(list2);
        assertEquals("[AH,2H,3H,6D,7D,8D]", list1.toString());
    }
    
}
