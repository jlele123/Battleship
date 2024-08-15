package github;

import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");
        System.out.println("Choose game mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        int choice = scanner.nextInt();

        Player player1 = new Player();
        Player player2;

        if (choice == 1) {
            player2 = new Player();
        } else {
            player2 = new ComputerPlayer();
        }

        System.out.println("Player 1, place your ships.");
        player1.placeShips();
        System.out.println("Player 2, place your ships.");
        player2.placeShips();

        boolean gameOn = true;
        Player currentPlayer = player1;
        Player opponent = player2;

        while (gameOn) {
            currentPlayer.printBoards(false);
            boolean hit = currentPlayer.takeTurn(opponent);
            if (hit) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }

        scanner.close();
    }
}