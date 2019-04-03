package com.codecool.battleofcards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import com.codecool.battleofcards.Card.Cards;


public class Game {
    private Pile table;
    private List<Player> players;

    public Game(int players) {
        this.table = new Pile(Pile.PileType.table);
        this.players = new ArrayList<>();
        setPlayers(players);
        setTablePile();
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

    public Card getWiningCard(String demand) throws IOException{
        ArrayList<Card> playerTopCards = getPlayersTopCards();
        for (Player player : players) {
            if(demand == "bribe"){
                Collections.sort(playerTopCards, new sortByBribes());
            }else if(demand == "support"){
                Collections.sort(playerTopCards, new sortBySupport());
            }else if(demand == "money"){
                Collections.sort(playerTopCards, new sortByMoney());
            }else throw new IOException("sorry somthing went wrong");
        }
        return playerTopCards.get(-1);
    }

    private ArrayList<Card> getPlayersTopCards(){
        ArrayList<Card> playerTopCards = new ArrayList<>();
        for (Player player : players) {
            playerTopCards.add(player.getStack().getTopCard());
        }
        return playerTopCards;
    }

}
