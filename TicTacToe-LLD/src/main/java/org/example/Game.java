package org.example;

import org.example.components.Board;
import org.example.components.Player;
import org.example.winningstrategy.WinnerStratergy;

import java.util.Scanner;

public class Game {
    Board board;
    Scanner sc;
    WinnerStratergy winnerStratergy;
    public Game(Board board){
        this.sc = new Scanner(System.in);
        this.board = board;
        //Start the game
        startGame();
    }

    public void startGame(){
        Player current = board.getPlayerX();
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

            if(board.isWinner(current, r, c)){
                System.out.println("Congrats! " + current.getName() + " you won!");
                break;
            }

            current = (current == board.getPlayerX())?board.getPlayerO(): board.getPlayerX();
        }
    }

}
