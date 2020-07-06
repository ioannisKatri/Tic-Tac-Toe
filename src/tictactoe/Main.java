package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TicTacToe ticTacToe = new TicTacToe();
        Game game = new Game(ticTacToe);

        String nextMove;
        while (sc.hasNext()) {
            nextMove = sc.nextLine().trim();
            game.play(nextMove);
        }
    }
}
