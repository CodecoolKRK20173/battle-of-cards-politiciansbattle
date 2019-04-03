package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Pile table;
    private List<Player> players;

    public Game(int players) {
        this.table = new Pile(Pile.PileType.table);
        this.players = new ArrayList<>();
        setPlayers(players);
    }


    private void setPlayers(int players){
        for (int i = 0; i < players; i++) {
            this.players.add(new Player());
        }
    }

    public void dealCards(){
        int numOfPlayers = players.size();
        int restFromDivision = table.getCards().size()%numOfPlayers;
        
        if (restFromDivision > 0){
            for (int i = 0; i < restFromDivision; i++)
                table.removeCard(i);
        }
        while (!(table == null)){
            for (int last = table.getCards().size(), ind=0; ind<players.size(); ind++){
                players.get(ind).addCardToPile(table.getCard(last));
                table.removeCard(last);
            }
        }
        
        
    }



}
