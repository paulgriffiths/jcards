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

import static java.lang.Math.pow;
import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class RanksByCountTest {
    private static final CardCounter cc = new CardCounter(new CardList(
                                                    Card.THREE_CLUBS,
                                                    Card.FIVE_HEARTS,
                                                    Card.FIVE_DIAMONDS,
                                                    Card.SIX_SPADES,
                                                    Card.SIX_HEARTS,
                                                    Card.NINE_HEARTS,
                                                    Card.NINE_CLUBS,
                                                    Card.NINE_SPADES,
                                                    Card.JACK_DIAMONDS,
                                                    Card.QUEEN_SPADES,
                                                    Card.KING_DIAMONDS,
                                                    Card.ACE_SPADES,
                                                    Card.ACE_CLUBS));
    private static final CardCounter ccEmpty = new CardCounter(new CardList());
    
    public RanksByCountTest() {
    }
 
    @Test
    public void testHasRankCount() {
        assertTrue(cc.hasRankCount(1));
        assertTrue(cc.hasRankCount(2));
        assertTrue(cc.hasRankCount(3));
        assertFalse(cc.hasRankCount(4));
        assertFalse(cc.hasRankCount(5));
        assertFalse(cc.hasRankCount(6));
    }
    
    @Test
    public void testRankByCount() {
        assertEquals(4, cc.numberRankByCount(1));
        assertEquals(3, cc.numberRankByCount(2));
        assertEquals(1, cc.numberRankByCount(3));
        assertEquals(0, cc.numberRankByCount(4));
        assertEquals(0, cc.numberRankByCount(5));
        assertEquals(0, cc.numberRankByCount(6));
    }
    
    @Test
    public void testHighestRankByCount() {
        assertEquals(Ranks.KING, cc.highestRankByCount(1));
        assertEquals(Ranks.ACE, cc.highestRankByCount(2));
        assertEquals(Ranks.NINE, cc.highestRankByCount(3));
        assertEquals(null, cc.highestRankByCount(4));
        assertEquals(null, cc.highestRankByCount(5));
        assertEquals(null, cc.highestRankByCount(6));   
    }
    
    @Test
    public void testSecondHighestRankByCount() {
        assertEquals(Ranks.QUEEN, cc.secondHighestRankByCount(1));
        assertEquals(Ranks.SIX, cc.secondHighestRankByCount(2));
        assertEquals(null, cc.secondHighestRankByCount(3));
        assertEquals(null, cc.secondHighestRankByCount(4));
        assertEquals(null, cc.secondHighestRankByCount(5));
        assertEquals(null, cc.secondHighestRankByCount(6));   
    }
    
    @Test
    public void testLowestRankByCount() {
        assertEquals(Ranks.THREE, cc.lowestRankByCount(1));
        assertEquals(Ranks.FIVE, cc.lowestRankByCount(2));
        assertEquals(Ranks.NINE, cc.lowestRankByCount(3));
        assertEquals(null, cc.lowestRankByCount(4));
        assertEquals(null, cc.lowestRankByCount(5));
        assertEquals(null, cc.lowestRankByCount(6));   
    }
    
    @Test
    public void testRankRangeByCount() {
        assertEquals(13 - 3, cc.rankRangeByCount(1));
        assertEquals(14 - 5, cc.rankRangeByCount(2));
        assertEquals(9 - 9, cc.rankRangeByCount(3));
        
        try {
            assertEquals(0, cc.rankRangeByCount(4));
            fail("Exception failed to throw");
        }
        catch ( NoSuchElementException e ) {
        }
    }
    
    @Test
    public void testRankScoreByCount() {
        final int mul = Ranks.highestValue();
        
        int expectedScore = (13 * (int) pow(mul, 3)) + (12 * (int) pow(mul, 2)) +
                            (11 * mul) + 3;
        assertEquals(expectedScore, cc.rankScoreByCount(1));
        
        expectedScore = (14 * (int) pow(mul, 2)) + (6 * mul) + 5;
        assertEquals(expectedScore, cc.rankScoreByCount(2));
        
        assertEquals(9, cc.rankScoreByCount(3));
        assertEquals(0, cc.rankScoreByCount(4));
        assertEquals(0, cc.rankScoreByCount(5));
        assertEquals(0, cc.rankScoreByCount(6));
    }
    
    @Test
    public void testEmptyList() {
        assertFalse(ccEmpty.hasRankCount(2));
        assertEquals(0, ccEmpty.numberRankByCount(3));
        assertEquals(null, ccEmpty.highestRankByCount(1));
        assertEquals(null, ccEmpty.secondHighestRankByCount(4));
        assertEquals(null, ccEmpty.lowestRankByCount(5));
        
        try {
            assertEquals(0, cc.rankRangeByCount(7));
            fail("Exception failed to throw");
        }
        catch ( NoSuchElementException e ) {
        }
        
        assertEquals(0, cc.rankScoreByCount(6));
    }
}
