package tictactoe;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    private boolean gameFinished = false;
    private CellType currentPayerSymbol;
    private final String[][] ticTacToe = new String[3][3];
    private final Player playerX;
    private final Player playerO;

    public TicTacToe() {
        currentPayerSymbol = CellType.X;
        playerX = new Player(CellType.X, true);
        playerO = new Player(CellType.O, false);
        populateCells();
        printTable();
        enterCoordinates();
    }

    public void printTable() {
        System.out.println("---------");

        for (String[] strings : ticTacToe) {
            System.out.print("| ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("|\n");
        }

        System.out.println("---------");
    }

    public void enterCoordinates() {
        System.out.print("Enter the coordinates: ");
    }

    public void populateCells() {
        for (String[] strings : ticTacToe) {
            Arrays.fill(strings, "_");
        }
    }

    public void verifyCurrentState() {
        String gameStatus = "";
        States states = findGamesState();

        if (states == States.GAME_NOT_FINISHED) {
            gameStatus = States.GAME_NOT_FINISHED.name;
        } else if (states == States.X_WINS) {
            gameStatus = States.X_WINS.name;
            gameFinished = true;
        } else if (states == States.O_WINS) {
            gameStatus = States.O_WINS.name;
            gameFinished = true;
        } else if (states == States.DRAW) {
            gameStatus = States.DRAW.name;
            gameFinished = true;
        } else if (states == States.IMPOSSIBLE) {
            gameStatus = States.IMPOSSIBLE.name;
            gameFinished = true;
        }

        if (gameFinished) {
            System.out.println(gameStatus);
            System.exit(1);
        }
    }

    public boolean isGameImpossible(long countO, long countX) {
        return countO - countX >= 2 || countX - countO >= 2;
    }


    public boolean isFinished() {
        long containsEmptySymbol = Arrays.stream(ticTacToe).filter(arr -> Arrays.toString(arr).contains(CellType.EMPTY.symbol)).count();
        return containsEmptySymbol == 0;
    }

    public boolean isCellEmpty(int y, int x) {
        return this.ticTacToe[y][x].equals("_");
    }

    private long countOccurrences(String occurrences, char findChar){
        return  occurrences.chars().filter( x -> {
            return x == findChar;
        }).count();
    }

    public States findGamesState() {
        List<Combinations> combinations = Combinations.getWinningCombinations();

        int oWins = 0;
        int xWins = 0;
//        long countX = 0;
//        long countO = 0;
        for (Combinations combination : combinations) {
            String winningCords = this.ticTacToe[combination.getFirstCoordinates().getX()][combination.getFirstCoordinates().getY()]
                    + this.ticTacToe[combination.getSecondCoordinates().getX()][combination.getSecondCoordinates().getY()]
                    + this.ticTacToe[combination.getThirdCoordinates().getX()][combination.getThirdCoordinates().getY()];

            if (winningCords.equals("OOO")) oWins++;
            if (winningCords.equals("XXX")) xWins++;
//            countX = countOccurrences(winningCords, 'X');
//            countO = countOccurrences(winningCords, 'O');
        }

        States gameState = null;
        if ((xWins == 1 && oWins == 1)) {
            gameState =  States.IMPOSSIBLE;
        } else if (xWins == 1) {
            gameState = States.X_WINS;
        } else if (oWins == 1) {
            gameState = States.O_WINS;
//        } else if (isGameImpossible(countO, countX)) {
//            return States.DRAW;;
        } else if (isFinished()) {
            gameState = States.DRAW;
        } else {
            gameState = States.GAME_NOT_FINISHED;
        }
        return gameState;
    }

    private boolean verifyCoordinates(int y, int x) {
        return y > 3 || y < 1 || x > 3 || x < 1;
    }

    public void play(String nextMove) {

        String[] coords = nextMove.split(" ");
        try {

            if (verifyCoordinates(Integer.parseInt(coords[1]), Integer.parseInt(coords[0]))) {
                System.out.println("Coordinates should be from 1 to 3!");
                return;
            }
            int x = Integer.parseInt(coords[0]) - 1;
            int y = 3 - Integer.parseInt(coords[1]);

            boolean isCellEmpty = isCellEmpty(y, x);
            if (!isCellEmpty) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                ticTacToe[y][x] = currentPayerSymbol.symbol;
                swapPlayer();
                printTable();
                verifyCurrentState();
            }
            enterCoordinates();
            System.out.println();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter a number");
        }

    }

    private void swapPlayer() {
        if (playerX.isMyTurn()) {
            playerX.setMyTurn(false);
            playerO.setMyTurn(true);
            currentPayerSymbol = playerO.getCellType();
        } else {
            playerX.setMyTurn(true);
            playerO.setMyTurn(false);
            currentPayerSymbol = playerX.getCellType();
        }
    }
}

