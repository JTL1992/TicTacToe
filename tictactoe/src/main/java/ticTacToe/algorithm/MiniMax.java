package ticTacToe.algorithm;


import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

/**
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 */
public class MiniMax {

    private static double maxPly;
    
    public static Coordinate perfectCoordinate;
    /**
     * MiniMax cannot be instantiated.
     */
    private MiniMax() {}

    /**
     * Execute the algorithm.
     * @param color        the player that the AI will identify as
     * @param game         the Tic Tac Toe board to play on
     * @param maxPly        the maximum depth
     */
    static void run (Color color, Game game, double maxPly) {
        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        MiniMax.maxPly = maxPly;
        int score = miniMax(color, game, 0);
    }

    /**
     * The meat of the algorithm.
     * @param color        the player that the AI will identify as
     * @param game         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int miniMax (Color color, Game game, int currentPly) {
        if (currentPly++ == maxPly || game.existTicTacToe() || game.complete()) {
            int score = score(color, game);
//            System.out.println("<------score------>:"+score);
//            System.out.println("<------max currentPly------>:"+currentPly);
            return score;
        }

        if (game.take() == color) {
//            System.out.println("<------max turn player------>:"+game.take());
//            System.out.println("<------max currentPly------>:"+currentPly);
            return getMax(color, game, currentPly);
        } else {
//            System.out.println("<------min turn player------>:"+game.take());
//            System.out.println("<------min currentPly------>:"+currentPly);
            return getMin(color, game, currentPly);
        }

    }

    /**
     * Play the move with the highest score.
     * @param color        the player that the AI will identify as
     * @param game         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMax (Color color, Game game, int currentPly) {
        double bestScore = Double.NEGATIVE_INFINITY;
        Coordinate coorOfBestMove = null;

        for (Coordinate coordinate : game.emptyCoordinates()) {

            Game newGame = game.deepClone();
            newGame.put(coordinate);
            newGame.change();
            int score = miniMax(color, newGame, currentPly);

            if (score >= bestScore) {
                bestScore = score;
                coorOfBestMove = coordinate;
            }

        }
        perfectCoordinate = coorOfBestMove;
        game.put(coorOfBestMove);
        game.change();
//        System.out.println("<------max index of best move------>:"+perfectCoordinate);
        return (int)bestScore;
    }

    /**
     * Play the move with the lowest score.
     * @param color        the player that the AI will identify as
     * @param game         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMin (Color color, Game game, int currentPly) {
        double bestScore = Double.POSITIVE_INFINITY;
        Coordinate coorOfBestMove = null;

        for (Coordinate theMove : game.emptyCoordinates()) {

            Game modifiedBoard = game.deepClone();
            modifiedBoard.put(theMove);
            modifiedBoard.change();
            int score = miniMax(color, modifiedBoard, currentPly);

            if (score <= bestScore) {
                bestScore = score;
                coorOfBestMove = theMove;
            }

        }
        perfectCoordinate = coorOfBestMove;
        game.put(coorOfBestMove);
        game.change();
//        System.out.println("<------min index of best move------>:"+perfectCoordinate);
        return (int)bestScore;
    }

    /**
     * Get the score of the board.
     * @param color        the play that the AI will identify as
     * @param game         the Tic Tac Toe board to play on
     * @return              the score of the board
     */
    private static int score (Color color, Game game) {
        if (color == Color.NONE) {
            throw new IllegalArgumentException("Player must be X or O.");
        }

        Color opponent = (color == Color.XS) ? Color.OS : Color.XS;

        if (game.existTicTacToe() && game.getWinner() == color) {
            return 10;
        } else if (game.existTicTacToe() && game.getWinner() == opponent) {
            return -10;
        } else {
            return 0;
        }
    }

}
