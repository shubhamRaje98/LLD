package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class SnakeAndLadderGame
{
    public static void main( String[] args ) {
        Queue<Player> players = new LinkedList<>();
        HashMap<Integer, Integer> snakeAndLadderMap = new HashMap<>();

        System.out.println( "Welcome to the snake and ladder game!" );

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of players: ");
        int noOfPlayers = sc.nextInt();
        sc.nextLine(); // Consume the enter

        while(noOfPlayers>0){
            int id = 1;
            System.out.println("Enter the player name: ");
            String name = sc.nextLine();
            System.out.println("adding the player : "+name);
            Player player = new Player(name, id++, 0);
            players.offer(player);

            noOfPlayers--;
        }

        for(Player player: players){
            System.out.println(player.getName());
        }
        System.out.println("All player are loaded");

        System.out.println("Enter number of snakes you want: ");
        int noOfSnakes = sc.nextInt();

        while(noOfSnakes>0){
            System.out.println("Enter the mouth cell of snake: ");
            int mouth = sc.nextInt();
            System.out.println("Enter the tail cell of snake: ");
            int tail = sc.nextInt();

            //can also add validation for entered values that mouth > tail should be true all the time
            snakeAndLadderMap.put(mouth, tail);
            noOfSnakes--;
        }

        System.out.println("Enter number of ladders you want: ");
        int noOfLadders = sc.nextInt();
        while(noOfLadders>0){
            System.out.println("Enter the start cell of ladder: ");
            int start = sc.nextInt();
            System.out.println("Enter the tail cell of ladder: ");
            int end = sc.nextInt();

            //can also add validation for entered values that mouth > tail should be true all the time
            snakeAndLadderMap.put(start, end);
            noOfLadders--;
        }
        System.out.println("Snakes and ladder loaded");

        System.out.println("How many dice do you want to play with: ");
        int noOfDice = sc.nextInt();

        Dice dice = new Dice(noOfDice);

        System.out.println("Enter the size of the board: ");
        int boardSize = sc.nextInt();

        GameBoard gameBoard = new GameBoard(boardSize, dice, players, snakeAndLadderMap);

        System.out.println("The whole board is initialized..\nEnter to start the game");
        sc.nextLine();

        gameBoard.startGame();
    }
}
