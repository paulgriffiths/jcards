/*
 * Copyright (C) 2015 Paul Griffiths
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
package RanksTest;

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.Ranks;

/**
 *
 * @author paul
 */
public class RanksTest {
    
    public RanksTest() {
        
    }
    
    @Test
    public void testCompareLessThan() {
        assertFalse(Ranks.ACE.compareTo(Ranks.TWO) < 0);
        assertTrue(Ranks.TWO.compareTo(Ranks.THREE) < 0);
        assertTrue(Ranks.THREE.compareTo(Ranks.FOUR) < 0);
        assertTrue(Ranks.FOUR.compareTo(Ranks.FIVE) < 0);
        assertTrue(Ranks.FIVE.compareTo(Ranks.SIX) < 0);
        assertTrue(Ranks.SIX.compareTo(Ranks.SEVEN) < 0);
        assertTrue(Ranks.SEVEN.compareTo(Ranks.EIGHT) < 0);
        assertTrue(Ranks.EIGHT.compareTo(Ranks.NINE) < 0);
        assertTrue(Ranks.NINE.compareTo(Ranks.TEN) < 0);
        assertTrue(Ranks.TEN.compareTo(Ranks.JACK) < 0);
        assertTrue(Ranks.JACK.compareTo(Ranks.QUEEN) < 0);
        assertTrue(Ranks.QUEEN.compareTo(Ranks.KING) < 0);
        assertTrue(Ranks.KING.compareTo(Ranks.ACE) < 0);
    }
    
    @Test
    public void testCompareGreaterThan() {
        assertFalse(Ranks.TWO.compareTo(Ranks.ACE) > 0);
        assertTrue(Ranks.THREE.compareTo(Ranks.TWO) > 0);
        assertTrue(Ranks.FOUR.compareTo(Ranks.THREE) > 0);
        assertTrue(Ranks.FIVE.compareTo(Ranks.FOUR) > 0);
        assertTrue(Ranks.SIX.compareTo(Ranks.FIVE) > 0);
        assertTrue(Ranks.SEVEN.compareTo(Ranks.SIX) > 0);
        assertTrue(Ranks.EIGHT.compareTo(Ranks.SEVEN) > 0);
        assertTrue(Ranks.NINE.compareTo(Ranks.EIGHT) > 0);
        assertTrue(Ranks.TEN.compareTo(Ranks.NINE) > 0);
        assertTrue(Ranks.JACK.compareTo(Ranks.TEN) > 0);
        assertTrue(Ranks.QUEEN.compareTo(Ranks.JACK) > 0);
        assertTrue(Ranks.KING.compareTo(Ranks.QUEEN) > 0);
    }
    
}
