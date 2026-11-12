package com.pluralsight;

import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            player1.addCard(deck.deal());
            player2.addCard(deck.deal());
        }

        System.out.println("\n----- BLACKJACK -----");

        System.out.println("\n" + player1.getName() + "'s Hand:");
        System.out.println(player1.getHand());
        System.out.println("Total Points: " + player1.getHandValue());

        System.out.println("\n" + player2.getName() + "'s Hand:");
        System.out.println(player2.getHand());
        System.out.println("Total Points: " + player2.getHandValue());

        int player1Points = player1.getHandValue();
        int player2Points = player2.getHandValue();

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
}
