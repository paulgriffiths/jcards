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
public class RankAndSuitTest {
    private static final CardCounter cc = new CardCounter(new CardList(
                                                    Card.ACE_SPADES,
                                                    Card.ACE_CLUBS,
                                                    Card.FIVE_CLUBS,
                                                    Card.SIX_SPADES,
                                                    Card.NINE_HEARTS,
                                                    Card.NINE_CLUBS,
                                                    Card.NINE_SPADES,
                                                    Card.QUEEN_SPADES));
    private static final CardCounter ccEmpty = new CardCounter(new CardList());
    
    public RankAndSuitTest() {
    }
    
    @Test
    public void testHasRank() {
        assertFalse(cc.hasRank(Ranks.TWO));
        assertFalse(cc.hasRank(Ranks.THREE));
        assertFalse(cc.hasRank(Ranks.FOUR));
        assertTrue(cc.hasRank(Ranks.FIVE));
        assertTrue(cc.hasRank(Ranks.SIX));
        assertFalse(cc.hasRank(Ranks.SEVEN));
        assertFalse(cc.hasRank(Ranks.EIGHT));
        assertTrue(cc.hasRank(Ranks.NINE));
        assertFalse(cc.hasRank(Ranks.TEN));
        assertFalse(cc.hasRank(Ranks.JACK));
        assertTrue(cc.hasRank(Ranks.QUEEN));
        assertFalse(cc.hasRank(Ranks.KING));
        assertTrue(cc.hasRank(Ranks.ACE));
    }
    
    @Test
    public void testHasSuit() {
        assertTrue(cc.hasSuit(Suits.CLUBS));
        assertTrue(cc.hasSuit(Suits.HEARTS));
        assertTrue(cc.hasSuit(Suits.SPADES));
        assertFalse(cc.hasSuit(Suits.DIAMONDS));
    }
    
    @Test
    public void testNumberRanks() {
        assertEquals(5, cc.numberRanks());
    }
    
    @Test
    public void testNumberSuits() {
        assertEquals(3, cc.numberSuits());
    }
    
    @Test
    public void testRankNumber() {
        assertEquals(0, cc.number(Ranks.TWO));
        assertEquals(0, cc.number(Ranks.THREE));
        assertEquals(0, cc.number(Ranks.FOUR));
        assertEquals(1, cc.number(Ranks.FIVE));
        assertEquals(1, cc.number(Ranks.SIX));
        assertEquals(0, cc.number(Ranks.SEVEN));
        assertEquals(0, cc.number(Ranks.EIGHT));
        assertEquals(3, cc.number(Ranks.NINE));
        assertEquals(0, cc.number(Ranks.TEN));
        assertEquals(0, cc.number(Ranks.JACK));
        assertEquals(1, cc.number(Ranks.QUEEN));
        assertEquals(0, cc.number(Ranks.KING));
        assertEquals(2, cc.number(Ranks.ACE));
    }
    
    @Test
    public void testSuitNumber() {
        assertEquals(3, cc.number(Suits.CLUBS));
        assertEquals(1, cc.number(Suits.HEARTS));
        assertEquals(4, cc.number(Suits.SPADES));
        assertEquals(0, cc.number(Suits.DIAMONDS));
    }
    
    @Test
    public void testEmptyList() {
        assertFalse(ccEmpty.hasRank(Ranks.FIVE));
        assertFalse(ccEmpty.hasSuit(Suits.DIAMONDS));
        assertEquals(0, ccEmpty.numberRanks());
        assertEquals(0, ccEmpty.numberSuits());
        assertEquals(0, ccEmpty.number(Ranks.TEN));
        assertEquals(0, ccEmpty.number(Suits.HEARTS));
    }
}
