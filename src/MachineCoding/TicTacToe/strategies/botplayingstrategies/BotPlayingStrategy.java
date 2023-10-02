package MachineCoding.TicTacToe.strategies.botplayingstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board);
}
