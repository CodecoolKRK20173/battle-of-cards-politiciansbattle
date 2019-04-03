package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Pile {
    private PileType pileType;
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public PileType getPileType() {
        return pileType;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void dealCards(int numberOfPlayers){
        
    }

    public void moveCardToPile(Card card){
        PileType.getPileType()
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
}


