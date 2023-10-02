package MachineCoding.TicTacToe;

import MachineCoding.TicTacToe.controllers.GameController;
import MachineCoding.TicTacToe.models.*;
import MachineCoding.TicTacToe.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.OrderOneRowWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //create game
        GameController gameController = new GameController();
        Game game;
        int dimension = 3;
        List<Player> players = List.of(
                new Player(new Symbol('X'),"Himanshu" , PlayerType.HUMAN),
                new Bot(new Symbol('O'),"Naman",BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new OrderOneColumnWinningStrategy(dimension,players),
                new OrderOneDiagonalWinningStrategy(players),
                new OrderOneRowWinningStrategy(dimension,players)
        );


        try{
            game = gameController.createGame(
                    dimension,
                    players,
                    winningStrategies
            );
        }catch(Exception e){
            System.out.println("Something went wrong!!!");
            return;
        }


        System.out.println("-------------Game is starting---------------");
        //while game status in_progress
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is how board look like");
            //print board
            gameController.displayBoard(game);
            //print if undo
            System.out.println("Do you want to undo? (y/n)");
            String input = scanner.next();
            //if yes -> call undo
            if(input.equals("y")){
                gameController.undo(game);
            }else{
                gameController.makeMove(game);
            }
        }
        //if winner -> print winner
        gameController.printResult(game);
        gameController.displayBoard(game);
    }
}
