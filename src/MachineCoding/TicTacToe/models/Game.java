package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;
    private Player winner;

    //constructor
    private Game(int dimension,List<Player> players,List<WinningStrategy> winningStrategies){
        this.moves = new ArrayList();
        this.board = new Board(dimension);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        this.gameStatus = GameStatus.IN_PROGRESS;
        //this.winner = null;
    }
    //getter and setter
    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void printBoard(){
        this.board.print();
    }

    public void printResult(){
        if(getGameStatus().equals(GameStatus.ENDED)){
            System.out.println("Game has ended.");
            System.out.println("Winner is : " + winner.getName());
        }else{
            System.out.println("Game has draw.");
        }
    }

    private boolean validateMove(Cell cell){
        int row = cell.getRow();
        int col = cell.getCol();

        if(row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()){
            return false;
        }

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;
    }

    public void undo(){
        if(moves.size() == 0){
            System.out.println("No move. can't undo");
            return;
        }
        Move lastMove = moves.get(moves.size() - 1);
        //winning hashmap update
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(board , lastMove);
        }
        //cell update
        Cell proposedCell = lastMove.getCell();
        Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellState(CellState.EMPTY);
        cellInBoard.setPlayer(null);
        //moves update
        moves.remove(moves.size() - 1);
        //current index update
        currentPlayerIndex -= 1;
        currentPlayerIndex += players.size();
        currentPlayerIndex %= players.size();
    }
    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");

        Cell proposedCell = currentPlayer.makeMove(board);
        System.out.println("Move made at row : " + proposedCell.getRow() + "" +
                "col : " + proposedCell.getCol());


        if(!validateMove(proposedCell)){
            System.out.println("Invalid move. Retry.");
            return;
        }
        //cell update
        Cell cellInBoard = cellUpdate(currentPlayer, proposedCell);

        //move update
        Move move = new Move(currentPlayer , cellInBoard);
        moves.add(move);

        //check winner
        if (checkGameWon(currentPlayer, move)) return;

        //check draw
        if (checkDraw()) return;

        currentPlayerIndex += 1;
        currentPlayerIndex %= players.size();
    }

    private Cell cellUpdate(Player currentPlayer, Cell proposedCell) {
        Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(currentPlayer);
        return cellInBoard;
    }

    private boolean checkDraw() {
        if(moves.size() == board.getSize() * board.getSize()){
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkGameWon(Player currentPlayer, Move move) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board , move)){
                gameStatus = GameStatus.ENDED;
                winner = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    //Builder
    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimensions;

        private Builder(){}

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        private boolean valid(){
            //minimum player check
            if(this.players.size() < 2){
                return false;
            }
            //
            if(this.players.size() != this.dimensions - 1){
                return false;
            }
            //bot check
            int botCount = 0;
            for(Player player : this.players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount += 1;
                }
            }

            if(botCount >= 2){
                return false;
            }

            //check unique symbols
            Set<Character> existingSymbols = new HashSet<>();
            for(Player player : players){
                if(existingSymbols.contains(player.getSymbol().getaChar())){
                    return false;
                }
                existingSymbols.add(player.getSymbol().getaChar());
            }
            return true;
        }

        public Game build(){
            if(!valid()){
                throw new RuntimeException("Invalid params for game");
            }
            return new Game(
                    dimensions,players,winningStrategies
            );
        }
    }
}
