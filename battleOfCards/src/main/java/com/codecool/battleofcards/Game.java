package com.codecool.battleofcards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.codecool.battleofcards.Card.Cards;


public class Game {
    private Pile table;
    private List<Player> players;

    public Game(int players) {
        this.table = new Pile(Pile.PileType.table);
        this.players = new ArrayList<>();
        setPlayers(players);
        setTablePile();
        dealCards();
    }
    public List<Player> getPlayers(){
        return players;
    }


    private void setPlayers(int players){
        for (int i = 0; i < players; i++) {
            this.players.add(new Player());
        }
    }

    private void setTablePile(){
        for (Cards var : Cards.values()) {
            table.addCard(new Card(var));
        }
    }

    public Pile getTable(){
        return table;
    }

    public Card getWiningCard(String demand) {

        ArrayList<Card> playerTopCards = getPlayersTopCards();
        int topCard =  playerTopCards.size()-1;
        for (Card var : playerTopCards) {
            System.out.println(var.toString() + " BEFORE SORT");
        }

        for (int i = 0; i<players.size(); i++) {
            if(demand == "bribe"){
                Collections.sort(playerTopCards, new sortByBribes());
            }else if(demand == "support"){
                Collections.sort(playerTopCards, new sortBySupport());
            }else if(demand == "money"){
                Collections.sort(playerTopCards, new sortByMoney());
            }

        }
        for (Card var : playerTopCards) {
            System.out.println(var.toString() + " AFTER SORT");
        }

        return playerTopCards.get(topCard);
    }

    private ArrayList<Card> getPlayersTopCards(){
        ArrayList<Card> playerTopCards = new ArrayList<>();
        for (Player player : players) {
            playerTopCards.add(player.getStack().getTopCard());
        }
        return playerTopCards;
    }

    public void moveCardToWinner(int winnerIndex){
        int topCard = 0;
        for (Player player : players) {
            players.get(winnerIndex).getStack().addCard(player.getStackTopCard());
            System.out.println(player.getStack().getCards().get(topCard).toString());
            player.getStack().getCards().remove(topCard);

        }
    }

    public int getWinnerIndex(Card card) {
        int winnerIndex = 0;
        for (Player player : players) {
            if(player.getStackTopCard() == card){
                winnerIndex = players.indexOf(player);
            }
        }
        return winnerIndex;
    }
    public void dealCards(){
        int numOfPlayers = players.size();
        int restFromDivision = table.getCards().size()%numOfPlayers;
        if (restFromDivision > 0){
            for (int i = 0; i < restFromDivision; i++)
                table.removeCard(i);
        }
        int maxIterations = table.getCards().size() / players.size();
        for (int i = 0; i < maxIterations; i++) {
            for (int ind=0; ind<players.size() ; ind++){
                players.get(ind).addCardToPile(table.getCard(0));
                table.removeCard(0);

            }
        }
    }

    public void deleteLoser(){
        List<Player> playersCopy = players;
        for (int i=0; i< playersCopy.size(); i++){
            if (players.get(i).getStack().getCards().size() == 0){
                players.remove(i);
            }
        }

    }

    public void printStatistis(){
        System.out.println("Numbers of players in game"+ players.size());
        for (int j=0; j<players.size(); j++) {
            System.out.println("Player" + j + " has " + players.get(j).getStack().getCards().size() +
            " cards left");

        }

    }

}
