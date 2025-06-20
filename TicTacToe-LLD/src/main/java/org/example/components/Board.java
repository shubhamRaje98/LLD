package org.example.components;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    Player playerX;
    Player playerO;
    int boardSize;
    Symbol[][] board;

    int movesPlayed;

    public Board(Player playerX, Player playerO, int boardSize){
        this.playerX = playerX;
        this.playerO = playerO;
        this.boardSize = boardSize;
        this.movesPlayed = 0;
        board = new Symbol[boardSize][boardSize];

    }


    public void printBoard(){
        System.out.println("***Printing the board***");
        for(int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                System.out.print((board[i][j]==null?" ":board[i][j]) + " | ");
            }
            System.out.println();
        }
    }
    public boolean isDraw(){
        if(movesPlayed == boardSize*boardSize){
            return true;
        }
        return false;
    }

    public void move(Player player, int row, int col){
        if(isValid(row, col)){
            movesPlayed++;

            System.out.println("Moving "+row+ " "+col);
            board[row][col] = player.getPlayer();
        }else{
            System.out.println("Invalid move, try again!!!");
        }
    }
    public void restart(){
        board = new Symbol[boardSize][boardSize];
    }
    public boolean isValid(int row, int col){
        if((row>=boardSize || col >= boardSize) || (row < 0 || col < 0) || (board[row][col]==Symbol.X || board[row][col]==Symbol.O)) {
            return false;
        } else{
            return true;
        }
    }


}
