package org.example.winningstrategy;

import org.example.components.Player;
import org.example.components.Symbol;

public interface WinnerStratergy {
    public boolean isWinner(Symbol[][] board, int boardSize, Player player, int row, int col);
}
