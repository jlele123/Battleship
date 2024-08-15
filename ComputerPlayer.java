package github;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer() {
        super();
        random = new Random();
    }

    @Override
    public void placeShips() {
        int[] shipLengths = {5, 4, 3, 3, 2};
        for (int length : shipLengths) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                boolean horizontal = random.nextBoolean();
                placed = getBoard().placeShip(x, y, length, horizontal);
            }
        }
    }

    @Override
    public boolean takeTurn(Player opponent) {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return opponent.getBoard().takeShot(x, y);
    }
}