package com.pluralsight;

import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String player1Name = promptForPlayerName("Enter Player 1 name: ");
        String player2Name = promptForPlayerName("Enter Player 2 name: ");

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Deck deck = new Deck();
        deck.shuffle();

        dealCards(player1, deck, player2);

        displayGame(player1, player2);

        int player1Points = player1.getHandValue();
        int player2Points = player2.getHandValue();

        recordResults(player1Points, player2Points, player2, player1);
    }

    private static void dealCards(Player player1, Deck deck, Player player2) {
        for (int i = 0; i < 2; i++) {
            player1.addCard(deck.deal());
            player2.addCard(deck.deal());
        }
    }

    public static String promptForPlayerName(String prompt) {

        System.out.print(prompt);

        return scanner.nextLine();
    }

    private static void recordResults(int player1Points, int player2Points, Player player2, Player player1) {
        System.out.println("\n---- RESULTS ----");

        if (player1Points > 21 && player2Points > 21) {
            System.out.println("Both players busted!");

        } else if (player1Points > 21) {
            System.out.println(player2.getName() + " wins!");

        } else if (player2Points > 21) {
            System.out.println(player1.getName() + " wins!");

        } else if (player1Points > player2Points) {
            System.out.println(player1.getName() + " wins!");

        } else if (player2Points > player1Points) {
            System.out.println(player2.getName() + " wins!");

        } else {
            System.out.println("It's a tie!");
        }
    }

    private static void displayGame(Player player1, Player player2) {
        System.out.println("\n----- BLACKJACK -----");

        System.out.println("\n" + player1.getName() + "'s Hand:");
        System.out.println(player1.getHand());
        System.out.println("Total Points: " + player1.getHandValue());

        System.out.println("\n" + player2.getName() + "'s Hand:");
        System.out.println(player2.getHand());
        System.out.println("Total Points: " + player2.getHandValue());
    }
}
