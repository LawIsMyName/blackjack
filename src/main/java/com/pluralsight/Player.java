package com.pluralsight;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
    public void addCard(Card card) {
        hand.deal(card);
    }

    public int getHandValue() {
        return hand.getValue();
    }
}
