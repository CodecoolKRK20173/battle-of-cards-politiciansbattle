package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Card getCard(int index){
        return cards.get(index);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    public void removeCard(int index){
        cards.remove(index);
    }





    Pile(PileType pileType){
        this.cards = new ArrayList<>();
        this.pileType = pileType;
    }

    public Card getTopCard(){
        return cards.get(0);
    }

    public enum PileType{
        stack,
        hand,
        table
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public String toString(){
        return Arrays.toString(cards.toArray());
    }
}


