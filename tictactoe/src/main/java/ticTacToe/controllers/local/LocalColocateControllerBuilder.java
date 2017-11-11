package ticTacToe.controllers.local;

import ticTacToe.models.Game;

abstract class LocalColocateControllerBuilder {

	protected Game game;

	protected LocalColocateController colocateController;

	protected LocalColocateControllerBuilder(Game game) {
		assert game != null;
		this.game = game;
	}

	abstract void build();

	void build(LocalCoordinateController localCoordinateController) {
		assert localCoordinateController != null;
		colocateController = new LocalPutController(game,
				localCoordinateController);
	}

	LocalColocateController getColocateController() {
		assert colocateController != null;
		return colocateController;

	}
}
