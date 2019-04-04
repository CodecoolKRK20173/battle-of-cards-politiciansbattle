package com.codecool.battleofcards;

import java.io.IOException;
import java.util.ArrayList;
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
        System.out.println(this.table.getCards().size()+" table size");
        System.out.println(this.players.size()+" players numb");


        for (Player player : this.players) {
            System.out.println(player.getStack().getCards().size() + " player deck size");
        }
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
        int topCard = 0;
        ArrayList<Card> playerTopCards = getPlayersTopCards();
        System.out.println(playerTopCards.size()+" player top cards size");
        for (Player player : players) {
            if(demand == "bribe"){
                Collections.sort(playerTopCards, new sortByBribes());
            }else if(demand == "support"){
                Collections.sort(playerTopCards, new sortBySupport());
            }else if(demand == "money"){
                Collections.sort(playerTopCards, new sortByMoney());
            }
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
        // System.out.println(restFromDivision+" rest from div");
        if (restFromDivision > 0){
            for (int i = 0; i < restFromDivision; i++)
                table.removeCard(i);
        }
        System.out.println(table.toString());
        int maxIterations = table.getCards().size() / players.size();
        for (int i = 0; i < maxIterations; i++) {
            for (int ind=0; ind<players.size() ; ind++){
                players.get(ind).addCardToPile(table.getCard(0));
                table.removeCard(0);

            }
        }

    }

}
