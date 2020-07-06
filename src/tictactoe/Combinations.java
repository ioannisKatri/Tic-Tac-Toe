package tictactoe;

import java.util.ArrayList;

class Combinations {
    private final Coordinates firstCoordinates;
    private final Coordinates secondCoordinates;
    private final Coordinates thirdCoordinates;
    private static ArrayList<Combinations> combinations;

    static {
        combinations = new ArrayList<>();

//            Horizontal
        combinations.add(new Combinations(new Coordinates(0, 0), new Coordinates(0, 1), new Coordinates(0, 2)));
        combinations.add(new Combinations(new Coordinates(1, 0), new Coordinates(1, 1), new Coordinates(1, 2)));
        combinations.add(new Combinations(new Coordinates(2, 0), new Coordinates(2, 1), new Coordinates(2, 2)));

//           Vertical
        combinations.add(new Combinations(new Coordinates(0, 0), new Coordinates(1, 0), new Coordinates(2, 0)));
        combinations.add(new Combinations(new Coordinates(0, 1), new Coordinates(1, 1), new Coordinates(2, 1)));
        combinations.add(new Combinations(new Coordinates(0, 2), new Coordinates(1, 2), new Coordinates(2, 2)));

//            diagonal
        combinations.add(new Combinations(new Coordinates(0, 0), new Coordinates(1, 1), new Coordinates(2, 2)));
        combinations.add(new Combinations(new Coordinates(2, 0), new Coordinates(1, 1), new Coordinates(0, 2)));
    }

    private Combinations(Coordinates firstCoordinates, Coordinates secondCoordinates, Coordinates thirdCoordinates) {
        this.firstCoordinates = firstCoordinates;
        this.secondCoordinates = secondCoordinates;
        this.thirdCoordinates = thirdCoordinates;
    }

    public static ArrayList<Combinations> getWinningCombinations() {
        return combinations;
    }

    public Coordinates getFirstCoordinates() {
        return firstCoordinates;
    }

    public Coordinates getSecondCoordinates() {
        return secondCoordinates;
    }

    public Coordinates getThirdCoordinates() {
        return thirdCoordinates;
    }
}
