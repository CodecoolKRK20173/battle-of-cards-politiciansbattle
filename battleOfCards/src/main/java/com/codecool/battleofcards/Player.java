package main.java.com.codecool.battleofcards;

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
}
