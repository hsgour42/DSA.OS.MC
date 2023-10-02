package MachineCoding.TicTacToe.strategies.botplayingstrategies;

import MachineCoding.TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel){
            return new EasyBotPlayingStrategy();
        //        return switch (difficultyLevel){
//            case EASY -> new EasyBotPlayingStrategy();
//            case MEDIUM -> new MediumPlayingStrategy();
//            case HARD -> new HardPlayingStrategy();
//        };

    }
}
