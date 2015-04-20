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
package net.paulgriffiths.pcards.machines;

/**
 *
 * @author paul
 */
public class SingleBettingMachine {
    private int pot;
    private int defaultBet;
    private int currentBet;
    private BettingMachineState state;
    
    public SingleBettingMachine(final int initialPot, final int defaultBet) {
        if ( initialPot < 1 ) {
            throw new IllegalArgumentException("initial pot must be greater than zero");
        }
        else if ( defaultBet < 1 ) {
            throw new IllegalArgumentException("default bet must be greater than zero");
        }
        else if ( defaultBet > initialPot ) {
            throw new IllegalArgumentException("default bet cannot exceed initial pot");
        }
        
        pot = initialPot;
        this.defaultBet = defaultBet;
        this.currentBet = defaultBet;
        state = BettingMachineState.READY_FOR_BET;
    }
    
    public int getPot() {
        return pot;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }
    
    public int getDefaultBet() {
        return defaultBet;
    }
    
    public BettingMachineState getState() {
        return state;
    }
    
    public void bet() throws OutOfMoneyException {
        if ( pot == 0 ) {
            throw new OutOfMoneyException("no money left");
        }
        bet(defaultBet);
    }
    
    public void bet(final int bet) throws OutOfMoneyException {
        validateReadyForBet();
        
        if ( bet == 0 ) {
            throw new IllegalArgumentException("you cannot bet zero");
        }
        else if ( bet < 0 ) {
            throw new IllegalArgumentException("bet cannot be negative");
        }
        else if ( bet > pot ) {
            throw new OutOfMoneyException("bet " + bet + " with pot " + pot);
        }
        
        currentBet = bet;
        pot -= bet;
        defaultBet = Math.min(bet, pot);
        setBetInProgress();
    }
    
    public void win(final double winRatio) {
        validateBetInProgress();
        pot += (int)(currentBet * winRatio);
        setReadyForBet();
    }
    
    public void lose() {
        validateBetInProgress();
        setReadyForBet();
    }
    
    private void setReadyForBet() {
        state = BettingMachineState.READY_FOR_BET;
    }
    
    private void setBetInProgress() {
        state = BettingMachineState.BET_IN_PROGRESS;
    }
    
    private void validateReadyForBet() {
        if ( state != BettingMachineState.READY_FOR_BET ) {
            throw new IllegalMachineStateException("not ready for bet");
        }
    }
    
    private void validateBetInProgress() {
        if ( state != BettingMachineState.BET_IN_PROGRESS ) {
            throw new IllegalMachineStateException("bet not in progress");
        }
    }
}
