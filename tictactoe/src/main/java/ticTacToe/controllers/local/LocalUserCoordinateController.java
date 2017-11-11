package ticTacToe.controllers.local;

import ticTacToe.controllers.CoordinateControllerVisitor;
import ticTacToe.controllers.UserCoordinateController;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class LocalUserCoordinateController extends LocalCoordinateController
	implements UserCoordinateController {

	protected LocalUserCoordinateController(Game game) {
		super(game);
	}

	@Override
	public Coordinate getTarget() {
		return new Coordinate();
	}

	@Override
	public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
		coordinateControllerVisitor.visit(this);
	}
	
}
