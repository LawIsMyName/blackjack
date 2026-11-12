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

    }
}
