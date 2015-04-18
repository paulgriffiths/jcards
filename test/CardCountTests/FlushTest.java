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
package CardCountTests;

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class FlushTest {
    
    public FlushTest() {
    }
    
    @Test
    public void testIsFlush() {
        CardList list = new CardList(Card.TWO_CLUBS, Card.FIVE_CLUBS,
                                     Card.EIGHT_CLUBS, Card.KING_CLUBS);
        
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isFlush());
    }
    
    @Test
    public void testIsntFlush() {
        CardList list = new CardList(Card.TWO_SPADES, Card.FIVE_SPADES,
                                     Card.EIGHT_DIAMONDS, Card.KING_SPADES);
        
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isFlush());
    }
}
