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
		Game game = this.getGame().deepClone();
		Coordinate target = RobotStrategy.miniMax(game);
		return target;
	}

	@Override
	public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
		coordinateControllerVisitor.visit(this);
	}

}
