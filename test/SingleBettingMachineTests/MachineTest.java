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
public class MachineTest {
    
    public MachineTest() {
    }
    
    @Test(expected=IllegalMachineStateException.class)
    public void testImmediateWinThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.win(1);
    }
    
    @Test(expected=IllegalMachineStateException.class)
    public void testImmediateLoseThrows() {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.lose();
    }
    
    @Test
    public void testFirstDefaultBet() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet();
        assertEquals(95, bm.getPot());
        assertEquals(5, bm.getDefaultBet());
        assertEquals(5, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
    }
    
    @Test
    public void testFirstSpecifiedBet() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet(10);
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
    }
    
    @Test(expected=IllegalMachineStateException.class)
    public void testBetTwiceThrows() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet();
        bm.bet();
    }
    
    @Test
    public void testBetAndWin() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet(10);
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.win(2);
        assertEquals(110, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test
    public void testBetAndLose() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet(10);
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.lose();
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test
    public void testBetAndWinAndBetAndWin() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet(10);
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.win(2);
        assertEquals(110, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
        
        bm.bet(25);
        assertEquals(85, bm.getPot());
        assertEquals(25, bm.getDefaultBet());
        assertEquals(25, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.win(3);
        assertEquals(160, bm.getPot());
        assertEquals(25, bm.getDefaultBet());
        assertEquals(25, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test
    public void testBetAndWinAndBetAndLose() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(100, 5);
        bm.bet(10);
        assertEquals(90, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.win(2);
        assertEquals(110, bm.getPot());
        assertEquals(10, bm.getDefaultBet());
        assertEquals(10, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
        
        bm.bet(15);
        assertEquals(95, bm.getPot());
        assertEquals(15, bm.getDefaultBet());
        assertEquals(15, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.lose();
        assertEquals(95, bm.getPot());
        assertEquals(15, bm.getDefaultBet());
        assertEquals(15, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
    }
    
    @Test
    public void testDefaultBetReductionPartial() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(20, 15);
        bm.bet();
        assertEquals(5, bm.getPot());
        assertEquals(5, bm.getDefaultBet());
        assertEquals(15, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
    }
    
    @Test
    public void testDefaultBetReductionFull() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(20, 15);
        bm.bet(20);
        assertEquals(0, bm.getPot());
        assertEquals(0, bm.getDefaultBet());
        assertEquals(20, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
    }
    
    @Test
    public void testBetAndLoseAndDefaultBetAndOutOfMoney() {
        SingleBettingMachine bm = new SingleBettingMachine(20, 20);
        try {
            bm.bet();
        }
        catch (OutOfMoneyException e) {
            fail("OutOfMoneyException unexpectedly thrown");
        }
        
        assertEquals(0, bm.getPot());
        assertEquals(0, bm.getDefaultBet());
        assertEquals(20, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.lose();
        assertEquals(0, bm.getPot());
        assertEquals(0, bm.getDefaultBet());
        assertEquals(20, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
        
        try {
            bm.bet();
            fail("OutOfMoneyException not thrown");
        }
        catch (OutOfMoneyException e) {
            
        }
    }
    
    @Test
    public void testBetAndLoseAndSpecifiedBetAndOutOfMoney() {
        SingleBettingMachine bm = new SingleBettingMachine(20, 15);
        try {
            bm.bet();
        }
        catch (OutOfMoneyException e) {
            fail("OutOfMoneyException unexpectedly thrown");
        }
        
        assertEquals(5, bm.getPot());
        assertEquals(5, bm.getDefaultBet());
        assertEquals(15, bm.getCurrentBet());
        assertEquals(BettingMachineState.BET_IN_PROGRESS, bm.getState());
        
        bm.lose();
        assertEquals(5, bm.getPot());
        assertEquals(5, bm.getDefaultBet());
        assertEquals(15, bm.getCurrentBet());
        assertEquals(BettingMachineState.READY_FOR_BET, bm.getState());
        
        try {
            bm.bet(10);
            fail("OutOfMoneyException not thrown");
        }
        catch (OutOfMoneyException e) {
            
        }
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroBetThrows() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(20, 15);
        bm.bet(0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeBetThrows() throws OutOfMoneyException {
        SingleBettingMachine bm = new SingleBettingMachine(20, 15);
        bm.bet(-1);
    }
}
