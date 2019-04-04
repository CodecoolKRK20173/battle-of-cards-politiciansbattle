package com.codecool.battleofcards;

import java.util.Arrays;
import java.util.Random;

public class Controller{
    public void runGame(){
        String answer;
        Random rand = new Random();
        Game xd = new Game(5);
        int actualPLayer = rand.nextInt(xd.getPlayers().size());

        do{

            while(xd.getPlayers().size()>1){
                System.out.println((xd.getPlayers().toString()));
                System.out.println("actaull player: number"+ actualPLayer + " \n" + xd.getPlayers().get(actualPLayer).getStackTopCard());

                String orderStatistic = View.chooseValueToCompare();
                Card winner = xd.getWiningCard(orderStatistic);
                System.out.println("top card " +winner.toString());
                int winnercardindex = xd.getWinnerIndex(winner);

                xd.moveCardToWinner(winnercardindex);
                xd.printStatistis();
                xd.deleteLoser();
                winnercardindex = xd.getWinnerIndex(winner);

                actualPLayer = winnercardindex;


                // View.makeAPause(5000);
                // View.clearScreen();
            }
            answer = View.getAnswer();
            }while(answer.equals("yes"));


    }
}