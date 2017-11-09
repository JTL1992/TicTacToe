package ticTacToe.controllers.local;

import ticTacToe.controllers.CoordinateController;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public abstract class LocalCoordinateController extends LocalController
		implements CoordinateController {

	protected LocalCoordinateController(Game game) {
		super(game);
	}

	public abstract Coordinate getTarget();

}
