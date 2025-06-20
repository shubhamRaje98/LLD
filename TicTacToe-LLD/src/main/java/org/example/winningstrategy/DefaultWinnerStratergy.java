package org.example.winningstrategy;

import org.example.components.Player;
import org.example.components.Symbol;

public class DefaultWinnerStratergy implements WinnerStratergy {

    @Override
    public boolean isWinner(Symbol[][] board, int boardSize, Player player, int row, int col){
        int rSum = 0;
        int cSum = 0;

        for(int i = 0; i<boardSize; i++){
            rSum += symbolToInt(board[row][i]);
            cSum += symbolToInt(board[i][col]);
        }
        if(boardSize==Math.abs(rSum) || boardSize==Math.abs(cSum)){
            return true;
        }
        int dSum = 0;
        if(row==col){ // Player is on a diagonal check for diagonal win
            for(int i = 0; i<boardSize; i++){
                dSum += symbolToInt(board[row][i]);
            }

            if(boardSize==Math.abs(dSum)){
                return true;
            }
        }
        return false;
    }

    private int symbolToInt(Symbol symbol){
        return (symbol == null) ? 0 : (symbol == Symbol.X ? -1 : 1);
    }
}
