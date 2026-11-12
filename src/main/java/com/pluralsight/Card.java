package com.pluralsight;

public class Card {

    private String suit;
    private String value;
    private boolean faceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }

    public String getSuit() {
        // only return the suit if the card is face up
        if (faceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (faceUp) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (value.equals("A")) {
            return 11;
        } else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
            return 10;
        } else {
            return Integer.parseInt(value);
        }
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    @Override
    public String toString() {

        if (!faceUp) {
            return  "┌─────────┐\n" +
                    "│         │\n" +
                    "│    #    │\n" +
                    "│         │\n" +
                    "└─────────┘";
        }

        String symbol = "";

        if (suit.equals("Hearts")) {
            symbol = "♥";
        } else if (suit.equals("Diamonds")) {
            symbol = "♦";
        } else if (suit.equals("Spades")) {
            symbol = "♠";
        } else if (suit.equals("Clubs")) {
            symbol = "♣";
        }

         return "┌─────────┐\n" +
                String.format("│ %-2s      │\n", value) +
                "│         │\n" +
                String.format("│    %s    │\n", symbol) +
                "│         │\n" +
                String.format("│      %2s │\n", value) +
                "└─────────┘";
    }
}

