package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    private PileType pileType;
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public PileType getPileType() {
        return pileType;
    }



    Pile(PileType pileType){
        this.cards = new ArrayList<>();
        this.pileType = pileType;
    }

    public Card getTopCard(){
        return cards.get(-1);
    }

    public enum PileType{
        stack,
        hand,
        table
    }

    public void addCard(Card card){
        cards.add(card);
    }
}


