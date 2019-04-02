package main.java.com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    private List<Card> cards;
    PileType pileType;

    Pile(PileType pileType){
        this.cards = new ArrayList<>();
        this.pileType = pileType;
    }

}

enum PileType{
    stack,
    hand,
    table
}
