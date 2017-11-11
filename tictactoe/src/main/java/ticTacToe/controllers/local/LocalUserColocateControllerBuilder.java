package ticTacToe.controllers.local;

import ticTacToe.models.Game;

class LocalUserColocateControllerBuilder extends
		LocalColocateControllerBuilder {

	LocalUserColocateControllerBuilder(Game game) {
		super(game);
	}

	@Override
	void build() {
		this.build(new LocalUserCoordinateController(game));
	}

}
