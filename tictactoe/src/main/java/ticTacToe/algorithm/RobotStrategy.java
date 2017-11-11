package ticTacToe.algorithm;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class RobotStrategy {

    public static Coordinate miniMax(Game game) {
        AlphaBetaAdvanced.run(game.take(), game, Double.POSITIVE_INFINITY);
        return AlphaBetaAdvanced.perfectCoordinate;
    }

}
