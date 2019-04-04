package com.codecool.battleofcards;

import java.util.Comparator;

public class Card{
    private Cards politicians;
    Card(Cards politicians){
        this.politicians = politicians;
    }
    public Cards getPoliticians(){
        return politicians;
    }
    public enum Cards{
        LECH_KACZYNSKI("Lech Kaczyńki",45, 50, 40),
        LECH_WALESA("Lech Wałęsa",34, 67, 23),
        DONALD_TUSK("Donald Tusk",56,47,12),
        ANDRZEJ_DUDA("Andrzej Duda",38,45,76),
        BRONISŁAW_KOMOROWSKI("Bronisław Komorowski",67,55,32),
        JANUSZ_KORWIN_MIKKE("Janusz Korwin Mikke",36,73,55);

        String name;
        int support;
        int money;
        int bribes;

        Cards(String name, int support, int money, int bribes){
            this.name = name;
            this.support = support;
            this.money = money;
            this.bribes = bribes;
        }

        public String getName(){
            return this.name;
        }
        public int getBribes() {
            return this.bribes;
        }

        public int getMoney() {
            return this.money;
        }

        public int getSupport() {
            return this.support;
        }
    }
    public String toString(){
        String cardToString = politicians.getName() + " " +"Support: "+ politicians.getSupport() + " "
                            + "Money: "+ politicians.getMoney() + " " +"Bribes: "+ politicians.getBribes() + "\n";
        return cardToString;
    }
}


class sortBySupport implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        int diffrence = card1.getPoliticians().getSupport()- card2.getPoliticians().getSupport();
        if(diffrence>0){
            return 1;
        }
        if(diffrence<0){
            return -1;
        }
        if(diffrence==0){
            return 0;
        }
        return diffrence;
    }
}


class sortByMoney implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        int diffrence = card1.getPoliticians().getMoney()- card2.getPoliticians().getMoney();
        if(diffrence>0){
            return 1;
        }
        if(diffrence<0){
            return -1;
        }
        if(diffrence==0){
            return 0;
        }
        return diffrence;
    }
}


class sortByBribes implements Comparator<Card>{
    public int compare(Card card1, Card card2) {
        int diffrence = card1.getPoliticians().getBribes()- card2.getPoliticians().getBribes();
        if(diffrence>0){
            return 1;
        }
        if(diffrence<0){
            return -1;
        }
        if(diffrence==0){
            return 0;
        }
        return diffrence;
    }

}



