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
public class ToStringTest {
    
    public ToStringTest() {
    }
    
    @Test
    public void testToStringEmpty() {
        CardList list = new CardList();
        assertEquals("[]", list.toString());
    }
    
    @Test
    public void testToStringOneCard() {
        CardList list = new CardList();
        list.add(new Card(Ranks.FOUR, Suits.HEARTS));
        assertEquals("[4H]", list.toString());
    }
    
    @Test
    public void testToStringTwoCards() {
        CardList list = new CardList();
        list.add(new Card(Ranks.TWO, Suits.DIAMONDS));
        list.add(new Card(Ranks.TEN, Suits.CLUBS));
        assertEquals("[2D,TC]", list.toString());
    }
    
    @Test
    public void testToStringThreeCards() {
        CardList list = new CardList();
        list.add(new Card(Ranks.FIVE, Suits.SPADES));
        list.add(new Card(Ranks.JACK, Suits.DIAMONDS));
        list.add(new Card(Ranks.ACE, Suits.HEARTS));
        assertEquals("[5S,JD,AH]", list.toString());
    }
}
