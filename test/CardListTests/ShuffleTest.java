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
public class ShuffleTest {
    
    public ShuffleTest() {
    }
    
    @Test
    public void testShuffle() {
        CardList list = new CardList();
        list.add(new Card(Ranks.TWO, Suits.DIAMONDS));
        list.add(new Card(Ranks.THREE, Suits.DIAMONDS));
        list.add(new Card(Ranks.FOUR, Suits.DIAMONDS));
        list.add(new Card(Ranks.FIVE, Suits.DIAMONDS));
        list.add(new Card(Ranks.SIX, Suits.DIAMONDS));
        list.add(new Card(Ranks.SEVEN, Suits.DIAMONDS));
        list.add(new Card(Ranks.EIGHT, Suits.DIAMONDS));
        list.add(new Card(Ranks.NINE, Suits.DIAMONDS));
        
        assertEquals("[2D,3D,4D,5D,6D,7D,8D,9D]", list.toString());
        list.shuffle();
        
        //  Note: every once in a while, the following
        //  assertio will fail as a result of chance.
        
        assertFalse("[2D,3D,4D,5D,6D,7D,8D,9D]".equals(list.toString()));
    }
}
