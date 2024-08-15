package github;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private Board board;
    private Scanner scanner;

    public Player() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void placeShips() {
        int[] shipLengths = {5, 4, 3, 3, 2};
        for (int length : shipLengths) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Enter coordinates for ship of length " + length + " (format: x y horizontal(1 for yes, 0 for no)): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boolean horizontal = scanner.nextInt() == 1;
                placed = board.placeShip(x, y, length, horizontal);
                if (!placed) {
                    System.out.println("Invalid placement. Try again.");
                }
            }
        }
    }

    public boolean takeTurn(Player opponent) {
        System.out.println("Enter coordinates to take a shot (format: x y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return opponent.getBoard().takeShot(x, y);
    }

    public Board getBoard() {
        return board;
    }

    public void printBoards(boolean revealShips) {
        System.out.println("Your board:");
        board.printBoard(true);
        System.out.println("Opponent's board:");
        board.printBoard(revealShips);
    }
}