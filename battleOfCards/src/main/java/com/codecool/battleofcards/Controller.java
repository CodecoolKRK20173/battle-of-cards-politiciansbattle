package com.codecool.battleofcards;

public class Controller{
    public void runGame(){

        Game xd = new Game(2);
        String orderStatistic = View.chooseValueToCompare();
        Card winner = xd.getWiningCard(orderStatistic);
        int winnercardindex = xd.getWinnerIndex(winner);
        xd.moveCardToWinner(winnercardindex);
        for (Player player : xd.getPlayers()) {
            System.out.println(player.getStack().getCards().size() + " player deck size");
        }
    }
}