package org.example;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Dice {
    int noOfDices;
    Random random = new Random();
    public int rollTheDice(){
        int result =0;
        int noOfDices = this.noOfDices;
        while(noOfDices > 0){
            result = result + (random.nextInt(6)+1);
            System.out.println("Result: "+result + " "+"noOfDices: "+noOfDices);
            noOfDices--;
        }
        return result;
    }
}