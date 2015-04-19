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
public class StraightTest {
    
    public StraightTest() {
    }
    
    @Test
    public void testEmptyList() {
        CardList list = new CardList();
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isStraight());
    }
    
    @Test
    public void testOneCardStraight() {
        CardList list = new CardList(Card.NINE_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testOneCardWheelStraight() {
        CardList list = new CardList(Card.ACE_HEARTS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testTwoCardStraight() {
        CardList list = new CardList(Card.SEVEN_CLUBS, Card.EIGHT_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testTwoCardWheelStraight() {
        CardList list = new CardList(Card.TWO_HEARTS, Card.ACE_SPADES);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testTwoCardNotStraight() {
        CardList list = new CardList(Card.SEVEN_CLUBS, Card.NINE_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isStraight());
    }
    
    @Test
    public void testTwoCardWheelNotStraight() {
        CardList list = new CardList(Card.THREE_HEARTS, Card.ACE_SPADES);
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isStraight());
    }
    
    @Test
    public void testThreeCardStraight() {
        CardList list = new CardList(Card.SEVEN_CLUBS, Card.EIGHT_DIAMONDS,
                                     Card.SIX_HEARTS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testThreeCardWheelStraight() {
        CardList list = new CardList(Card.TWO_HEARTS, Card.ACE_SPADES,
                                     Card.THREE_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testThreeCardNotStraight() {
        CardList list = new CardList(Card.SEVEN_CLUBS, Card.EIGHT_DIAMONDS,
                                     Card.FIVE_HEARTS);
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isStraight());
    }
    
    @Test
    public void testThreeCardNotWheelStraight() {
        CardList list = new CardList(Card.TWO_HEARTS, Card.ACE_SPADES,
                                     Card.FOUR_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertFalse(cc.isStraight());
    }
    
    @Test
    public void testFourCardStraight() {
        CardList list = new CardList(Card.ACE_CLUBS, Card.JACK_DIAMONDS,
                                     Card.KING_SPADES, Card.QUEEN_HEARTS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
    
    @Test
    public void testFourCardWheelStraight() {
        CardList list = new CardList(Card.TWO_HEARTS, Card.ACE_SPADES,
                                     Card.FOUR_CLUBS, Card.THREE_DIAMONDS);
        CardCounter cc = new CardCounter(list);
        assertTrue(cc.isStraight());
    }
}
