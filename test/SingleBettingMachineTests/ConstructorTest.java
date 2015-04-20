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
package SingleBettingMachineTests;

import org.junit.Test;
import static org.junit.Assert.*;

import net.paulgriffiths.pcards.machines.*;

/**
 *
 * @author paul
 */
public class ConstructorTest {
    
    public ConstructorTest() {
    }
    
    @Test
    public void testGoodConstruction() {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        assertEquals(100, bm.getPot());
        assertEquals(5, bm.getDefaultBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test
    public void testDefaultBetEqualToInitialPotOK() {
        SingleBettingMachine bm = new SingleBettingMachine(20, 20);
        assertEquals(20, bm.getPot());
        assertEquals(20, bm.getDefaultBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroInitialPotThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(0, 1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeInitialPotThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(-1, 1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroDefaultBetThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(100, 0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeDefaultBetThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(100, -1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testDefaultBetGreaterThanInitialPotThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(20, 21);
    }
}
