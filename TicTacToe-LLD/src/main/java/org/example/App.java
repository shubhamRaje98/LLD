package org.example;

import org.example.components.Player;
import org.example.components.Symbol;
import org.example.winningstrategy.DefaultWinnerStratergy;
import org.example.winningstrategy.WinnerStratergy;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Player playerX;
        Player playerO;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player X name ");
        String name = sc.nextLine();


        playerX = new Player(1, name, Symbol.X);

        System.out.println("Enter player O name: ");
        String nameO = sc.nextLine();

        playerO = new Player(2, name, Symbol.O);

        System.out.println("Enter the board size: ");
        int boardSize = sc.nextInt();
        WinnerStratergy winnerStratergy = new DefaultWinnerStratergy();
        Game game = new Game(boardSize, playerX, playerO, winnerStratergy);
    }
}
