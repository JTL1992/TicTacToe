package ticTacToe.algorithm;


import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

/**
 * Uses the Alpha-Beta Pruning algorithm to play a move in a game of Tic Tac Toe
 * but includes depth in the evaluation function.
 *
 * The vanilla MiniMax algorithm plays perfectly but it may occasionally
 * decide to make a move that will results in a slower victory or a faster loss.
 * For example, playing the move 0, 1, and then 7 gives the AI the opportunity
 * to play a move at index 6. This would result in a victory on the diagonal.
 * But the AI does not choose this move, instead it chooses another one. It
 * still wins inevitably, but it chooses a longer route. By adding the depth
 * into the evaluation function, it allows the AI to pick the move that would
 * make it win as soon as possible.
 */
class AlphaBetaAdvanced {

    private static double maxPly;

    public static Coordinate perfectCoordinate;

    /**
     * AlphaBetaAdvanced cannot be instantiated.
     */
    private AlphaBetaAdvanced() {}

    /**
     * Execute the algorithm.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param maxPly        the maximum depth
     */
    static void run (Color player, Game board, double maxPly) {

        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        AlphaBetaAdvanced.maxPly = maxPly;
        alphaBetaPruning(player, board, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
    }

    /**
     * The meat of the algorithm.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param alpha         the alpha value
     * @param beta          the beta value
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int alphaBetaPruning (Color player, Game board, double alpha, double beta, int currentPly) {
        if (currentPly++ == maxPly || board.existTicTacToe() || board.complete()) {
            return score(player, board, currentPly);
        }

        if (board.take() == player) {
            return getMax(player, board, alpha, beta, currentPly);
        } else {
            return getMin(player, board, alpha, beta, currentPly);
        }
    }

    /**
     * Play the move with the highest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param alpha         the alpha value
     * @param beta          the beta value
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMax (Color player, Game board, double alpha, double beta, int currentPly) {
        Coordinate indexOfBestMove = null;

        for (Coordinate theMove : board.emptyCoordinates()) {
            Game modifiedBoard = board.deepClone();
            modifiedBoard.put(theMove);
            modifiedBoard.change();
            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);

            if (score > alpha) {
                alpha = score;
                indexOfBestMove = theMove;
            }

            if (alpha >= beta) {
                break;
            }
        }

        if (indexOfBestMove != null) {
            board.put(indexOfBestMove);
            board.change();
            perfectCoordinate = indexOfBestMove;
        }
        return (int)alpha;
    }

    /**
     * Play the move with the lowest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param alpha         the alpha value
     * @param beta          the beta value
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMin (Color player, Game board, double alpha, double beta, int currentPly) {
        Coordinate indexOfBestMove = null;

        for (Coordinate theMove : board.emptyCoordinates()) {
            Game modifiedBoard = board.deepClone();
            modifiedBoard.put(theMove);
            modifiedBoard.change();
            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);

            if (score < beta) {
                beta = score;
                indexOfBestMove = theMove;
            }

            if (alpha >= beta) {
                break;
            }
        }

        if (indexOfBestMove != null) {
            board.put(indexOfBestMove);
            board.change();
            perfectCoordinate = indexOfBestMove;
        }
        return (int)beta;
    }

    /**
     * Get the score of the board. Takes depth into account.
     * @param player        the play that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int score (Color player, Game board, int currentPly) {

        if (player == Color.NONE) {
            throw new IllegalArgumentException("Player must be X or O.");
        }

        Color opponent = (player == Color.XS) ? Color.OS : Color.XS;

        if (board.existTicTacToe() && board.getWinner() == player) {
            return 10 - currentPly;
        } else if (board.existTicTacToe() && board.getWinner() == opponent) {
            return -10 + currentPly;
        } else {
            return 0;
        }
    }

}
