package ticTacToe.controllers.local;

import ticTacToe.algorithm.RobotStrategy;
import ticTacToe.controllers.CoordinateControllerVisitor;
import ticTacToe.controllers.RandomCoordinateController;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class LocalRandomCoordinateController extends LocalCoordinateController
	implements RandomCoordinateController {

	protected LocalRandomCoordinateController(Game game) {
		super(game);
	}

	@Override
	public Coordinate getTarget() {
//		boolean ok;
//		do {
//			target.random();
//			ok = this.empty(target);
//		} while (!ok);
		return RobotStrategy.miniMax(this.getGame());
	}

	@Override
	public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
		coordinateControllerVisitor.visit(this);
	}

}
