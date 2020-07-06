package tictactoe;

public class Game {

    TicTacToe ticTacToe;

    public Game(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public void play(String nextMove) {
        ticTacToe.play(nextMove);
    }
}
