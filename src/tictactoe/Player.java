package tictactoe;

public class Player {
    private final CellType cellType;
    private boolean isMyTurn;

    public Player(CellType cellType, boolean isMyTurn) {
        this.cellType = cellType;
        this.isMyTurn = isMyTurn;
    }

    public CellType getCellType() {
        return cellType;
    }

    public boolean isMyTurn() {
        return isMyTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.isMyTurn = myTurn;
    }
}
