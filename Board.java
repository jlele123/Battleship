package github;

public class Board {
    private char[][] board;
    private static final int SIZE = 10;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '~'; // Water
            }
        }
    }

    public boolean placeShip(int x, int y, int length, boolean horizontal) {
        if (horizontal) {
            if (y + length > SIZE) return false;
            for (int i = 0; i < length; i++) {
                if (board[x][y + i] != '~') return false;
            }
            for (int i = 0; i < length; i++) {
                board[x][y + i] = 'S'; // Ship
            }
        } else {
            if (x + length > SIZE) return false;
            for (int i = 0; i < length; i++) {
                if (board[x + i][y] != '~') return false;
            }
            for (int i = 0; i < length; i++) {
                board[x + i][y] = 'S'; // Ship
            }
        }
        return true;
    }

    public boolean takeShot(int x, int y) {
        if (board[x][y] == 'S') {
            board[x][y] = 'X'; // Hit
            return true;
        } else if (board[x][y] == '~') {
            board[x][y] = 'O'; // Miss
            return false;
        }
        return false;
    }

    public void printBoard(boolean revealShips) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (revealShips) {
                    System.out.print(board[i][j] + " ");
                } else {
                    if (board[i][j] == 'S') {
                        System.out.print('~' + " ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}