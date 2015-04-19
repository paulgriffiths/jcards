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
package net.paulgriffiths.pcards;

/**
 *
 * @author paul
 */
public final class PokerHand extends Hand {
    public PokerHand(final Card card, final Card... cards) {
        super(card, cards);
        checkLegalSize();
    }
    
    public PokerHand(final PokerHand hand) {
        super(hand);
    }
    
    public PokerHand(final CardList list) {
        super(list);
        checkLegalSize();
    }
    
    private void checkLegalSize() {
        if ( size() != 5 ) {
            throw new IllegalArgumentException("poker hands must have five cards");
        }
    }
}
