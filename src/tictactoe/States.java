package tictactoe;

enum States {
    GAME_NOT_FINISHED("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    IMPOSSIBLE("Impossible");

    String name;

    States(String name) {
        this.name = name;
    }


}
