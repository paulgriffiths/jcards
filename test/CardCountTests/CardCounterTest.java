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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.*;

/**
 *
 * @author paul
 */
public class CardCounterTest {
    private CardList list;
    private CardCounter cc;
    
    public CardCounterTest() {
    }
    
    @Before
    public void setUp() {
        list = new CardList();
        list.add(new Card(Ranks.ACE, Suits.HEARTS));
        list.add(new Card(Ranks.ACE, Suits.DIAMONDS));
        list.add(new Card(Ranks.ACE, Suits.SPADES));
        list.add(new Card(Ranks.THREE, Suits.DIAMONDS));
        list.add(new Card(Ranks.THREE, Suits.CLUBS));
        list.add(new Card(Ranks.FOUR, Suits.HEARTS));
        list.add(new Card(Ranks.SIX, Suits.HEARTS));
        list.add(new Card(Ranks.SIX, Suits.CLUBS));
        list.add(new Card(Ranks.SIX, Suits.DIAMONDS));
        list.add(new Card(Ranks.SIX, Suits.SPADES));
        list.add(new Card(Ranks.NINE, Suits.CLUBS));
        list.add(new Card(Ranks.NINE, Suits.SPADES));
        list.add(new Card(Ranks.JACK, Suits.CLUBS));
        list.add(new Card(Ranks.JACK, Suits.SPADES));
        list.add(new Card(Ranks.JACK, Suits.DIAMONDS));
        list.add(new Card(Ranks.QUEEN, Suits.HEARTS));
        list.add(new Card(Ranks.KING, Suits.CLUBS));
        
        cc = new CardCounter(list);
    }
    
    @Test
    public void testNumberRank() {
        assertEquals(3, cc.number(Ranks.ACE));
        assertEquals(0, cc.number(Ranks.TWO));
        assertEquals(2, cc.number(Ranks.THREE));
        assertEquals(1, cc.number(Ranks.FOUR));
        assertEquals(0, cc.number(Ranks.FIVE));
        assertEquals(4, cc.number(Ranks.SIX));
        assertEquals(0, cc.number(Ranks.SEVEN));
        assertEquals(0, cc.number(Ranks.EIGHT));
        assertEquals(2, cc.number(Ranks.NINE));
        assertEquals(0, cc.number(Ranks.TEN));
        assertEquals(3, cc.number(Ranks.JACK));
        assertEquals(1, cc.number(Ranks.QUEEN));
        assertEquals(1, cc.number(Ranks.KING));
    }
    
    @Test
    public void testNumberSuit() {
        assertEquals(5, cc.number(Suits.CLUBS));
        assertEquals(4, cc.number(Suits.HEARTS));
        assertEquals(4, cc.number(Suits.SPADES));
        assertEquals(4, cc.number(Suits.DIAMONDS));
    }
    
    @Test
    public void testNumberHigh() {
        assertEquals(3, cc.numberSingles());
    }
    
    @Test
    public void testNumberPair() {
        assertEquals(2, cc.numberPairs());
    }
    
    @Test
    public void testNumberThree() {
        assertEquals(2, cc.numberThrees());
    }
    
    @Test
    public void testNumberFour() {
        assertEquals(1, cc.numberFours());
    }
    
    @Test
    public void testNumberRanks() {
        assertEquals(8, cc.numberRanks());
    }
    
    @Test
    public void testNumberSuits() {
        assertEquals(4, cc.numberSuits());
    }
    
    @Test
    public void testHasSingles() {
        assertTrue(cc.hasSingles());
    }
    
    @Test
    public void testHasNoSingles() {
        CardList newList = new CardList();
        newList.add(new Card(Ranks.TWO, Suits.HEARTS));
        newList.add(new Card(Ranks.TWO, Suits.CLUBS));
        newList.add(new Card(Ranks.THREE, Suits.HEARTS));
        newList.add(new Card(Ranks.THREE, Suits.CLUBS));
        newList.add(new Card(Ranks.THREE, Suits.SPADES));
        CardCounter newCc = new CardCounter(newList);
        assertFalse(newCc.hasSingles());
    }
    
    @Test
    public void testHighRank() {
        assertEquals(Ranks.KING, cc.highestSingleRank());
    }
    
    @Test
    public void testLowRank() {
        assertEquals(Ranks.FOUR, cc.lowestSingleRank());
    }
}
