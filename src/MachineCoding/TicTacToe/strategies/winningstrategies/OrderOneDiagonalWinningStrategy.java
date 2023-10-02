package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy{
    private Map<Symbol , Integer> leftDiagonalMap;
    private Map<Symbol , Integer> rightDiagonalMap;
    public OrderOneDiagonalWinningStrategy(List<Player> players){
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();

        for(Player player : players){
            leftDiagonalMap.put(player.getSymbol() , 0);
            rightDiagonalMap.put(player.getSymbol() , 0);
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Symbol symbol = move.getPlayer().getSymbol();
        if(row == col){
            leftDiagonalMap.put(symbol ,  leftDiagonalMap.get(symbol) + 1);

            if(leftDiagonalMap.get(symbol) == board.getSize()){
                return true;
            }
        }

        if(row + col == board.getSize() - 1){
            rightDiagonalMap.put(symbol,rightDiagonalMap.get(symbol) + 1);

            if(rightDiagonalMap.get(symbol) == board.getSize() - 1){
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board,Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            leftDiagonalMap.put(symbol , leftDiagonalMap.get(symbol) - 1);
        }

        if(row + col == board.getSize() - 1){
            rightDiagonalMap.put(symbol , rightDiagonalMap.get(symbol) - 1);
        }
    }
}
