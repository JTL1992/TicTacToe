package ticTacToe.controllers.local;

import ticTacToe.controllers.errors.ErrorGeneratorType;
import ticTacToe.controllers.ColocateController;
import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.errors.ErrorReport;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

abstract class LocalColocateController extends LocalOperationController
		implements ColocateController {

	private LocalCoordinateController coordinateController;

	protected LocalColocateController(Game game,
			LocalCoordinateController coordinateController) {
		super(game);
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}

	public ErrorReport validateTarget(Coordinate target) {
		if (!this.empty(target)) {
			return ErrorGeneratorType.NOT_EMPTY.getErrorReport(this.getGame());
		}
		return null;
	}

	public CoordinateController getCoordinateController() {
		return coordinateController;
	}

}
