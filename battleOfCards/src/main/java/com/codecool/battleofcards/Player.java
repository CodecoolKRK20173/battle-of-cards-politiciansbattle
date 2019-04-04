package com.codecool.battleofcards;

import java.util.Scanner;

public class Player {
    private Pile hand;
    private Pile stack;

    public Player() {
        this.hand = new Pile(Pile.PileType.stack);
        this.stack = new Pile(Pile.PileType.hand);
    }

    public Pile getHand() {
        return hand;
    }



    public Pile getStack() {
        return stack;
    }

    public Card getStackTopCard(){
        return stack.getTopCard();
    }

    public void addCardToPile(Card card){
        stack.addCard(card);
    }

    public String chooseValueToCompare(){
        System.out.println("which value you want to compare? Bribes, Money or Support");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("bribes") || answer.equalsIgnoreCase("money")
        || answer.equalsIgnoreCase("support")){
            return answer;
        } 
        else {
            System.out.println("Choose one of the options");
        }
        return "";
       
    }
}
