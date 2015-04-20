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
public enum BettingMachineState {
    READY_FOR_BET ("Ready for bet"),
    BET_IN_PROGRESS ("Bet in progress");
    
    private final String name;
    
    BettingMachineState(final String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
