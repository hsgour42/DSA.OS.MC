package MachineCoding.TicTacToe.models;

public class Move {
    private Player player;
    private Cell cell;

    //Constructor
    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    //Getter and Setter
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
