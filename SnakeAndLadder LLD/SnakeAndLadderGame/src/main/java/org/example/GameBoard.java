package org.example;

import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    HashMap<Integer, Integer> snakeAndLadderJumper; // trade off: can also use Snake and Ladder classes
    int BOARDSIZE;
    Dice dice;
    Queue<Player> players;

    GameBoard(int boardSize, Dice dice, Queue<Player> players, HashMap<Integer, Integer> snakeAndLadderJumper){
        this.snakeAndLadderJumper = snakeAndLadderJumper;
        this.BOARDSIZE = boardSize;
        this.players = players;
        this.dice = dice;
    }

    public void startGame(){
        System.out.println("Game started..");
        while(players.size()-1 > 0){
            System.out.println("board size: "+this.BOARDSIZE);
            Player player = players.poll();
            String playerName = player.getName();
            int currentCell = player.getCurrentCell();

            int diceNo = playDice(playerName);
            System.out.println("Dice rolled: "+diceNo);
            int nextCell = currentCell + diceNo;

            if(nextCell>this.BOARDSIZE){ // If the next position is out of bound
                System.out.println("Exceeding the board");
                nextCell = currentCell + (nextCell-this.BOARDSIZE);
            }

            if(snakeAndLadderJumper.containsKey(nextCell)){ // Check if player has arrived at snake or ladder
                if(currentCell > nextCell){
                    System.out.println(playerName + " you have been bitten by a snake");
                }else{
                    System.out.println(playerName + " you have the ladder!!");
                }
                nextCell = snakeAndLadderJumper.get(nextCell);
            }

            if(nextCell == this.BOARDSIZE){ //player won
                System.out.println(playerName + " won the game");
                continue;
            }
            player.setCurrentCell(nextCell);
            System.out.println(playerName + " your next position "+player.getCurrentCell());
            players.offer(player);
        }
    }
    public int playDice(String playerName){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to roll he dice "+ playerName);
        String in = sc.nextLine();

        return dice.rollTheDice();
    }
}
