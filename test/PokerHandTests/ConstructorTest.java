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
package PokerHandTests;

import org.junit.Before;
import org.junit.BeforeClass;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testConstructWithFiveCards() {
        PokerHand ph = new PokerHand(Card.ACE_CLUBS,
            Card.ACE_DIAMONDS, Card.ACE_HEARTS, Card.ACE_SPADES,
            Card.KING_CLUBS);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructWithFourCards() {
        PokerHand ph = new PokerHand(Card.ACE_CLUBS,
            Card.ACE_DIAMONDS, Card.ACE_HEARTS, Card.ACE_SPADES);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructWithSixCards() {
        PokerHand ph = new PokerHand(Card.ACE_CLUBS,
            Card.ACE_DIAMONDS, Card.ACE_HEARTS, Card.ACE_SPADES,
            Card.KING_CLUBS, Card.KING_DIAMONDS);
    }
}
