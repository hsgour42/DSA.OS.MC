package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
    void handleUndo(Board board,Move move);
}
