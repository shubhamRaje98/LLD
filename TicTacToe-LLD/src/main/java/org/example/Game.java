package org.example;

import org.example.components.Board;
import org.example.components.Player;
import org.example.winningstrategy.WinnerStratergy;

import java.util.Scanner;

public class Game {
    int boardSize;
    Board board;
    Scanner sc;
    Player playerX;
    Player playerO;

    WinnerStratergy winnerStratergy;
    public Game(int boardSize, Player playerX, Player playerO, WinnerStratergy winnerStratergy){
        this.boardSize = boardSize;
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board(playerX, playerO, boardSize);
        this.winnerStratergy = winnerStratergy;
        sc = new Scanner(System.in);

        //Start the game
        startGame();
    }

    public void startGame(){
        Player current = playerX;
        while(true){
            board.printBoard();

            System.out.println("Player " + current.getPlayer() + " please enter your next move");
            int r = sc.nextInt();
            int c = sc.nextInt();

            board.move(current, r, c);

            if(board.isDraw()){
                System.out.println("Its a draw play again!");
                break;
            }

            if(winnerStratergy.isWinner(board.getBoard(), boardSize, current, r, c)){
                System.out.println("Congrats! " + current.getName() + " you won!");
                break;
            }

            current = (current == playerX)?playerO: playerX;
        }
    }

}
