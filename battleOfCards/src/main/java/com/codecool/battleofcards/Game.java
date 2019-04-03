package com.codecool.battleofcards;

import java.util.ArrayList;
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

    // private void dealCards(){
    //     for (int i = 0; i < 6 ; i++) {
    //         table.addCard(card);
    //     }
    // }

}
