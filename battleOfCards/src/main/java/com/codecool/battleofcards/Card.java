package com.codecool.battleofcards;


import java.util.Comparator;

public class Card{
    int support;
    int money;
    int bribes;

    Card(int support, int money, int bribes){
        this.support = support;
        this.money = money;
        this.bribes = bribes;
    }

    public int getBribes() {
        return bribes;
    }

    public int getMoney() {
        return money;
    }

    public int getSupport() {
        return support;
    }


}

class sortBySupport implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        return card1.support - card2.support;
    }
}

class sortByMoney implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        return card1.money - card2.money;
    }
}

class sortByBribes implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        return card1.bribes - card2.bribes;
    }
}



