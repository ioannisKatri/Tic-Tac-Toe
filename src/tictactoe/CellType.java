package tictactoe;

enum CellType {
    EMPTY("_"),
    X("X"),
    O("O");

    String symbol;

    CellType(String symbol) {
        this.symbol = symbol;
    }
}
