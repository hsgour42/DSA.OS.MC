package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneColumnWinningStrategy implements WinningStrategy{
    private List<Map<Symbol, Integer>> colMaps;

    public OrderOneColumnWinningStrategy(int size, List<Player> players) {
        this.colMaps = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            colMaps.add(new HashMap<>());
            for (Player player : players) {
                colMaps.get(i).put(player.getSymbol(), 0);
            }
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        colMaps.get(col).put(symbol, 1 + colMaps.get(col).get(symbol));

        if (colMaps.get(col).get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board,Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        colMaps.get(col).put(symbol, colMaps.get(col).get(symbol) - 1);
    }
}
