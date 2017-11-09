package ticTacToe.controllers.local;

import ticTacToe.models.Game;

class LocalRandomColocateControllerBuilder extends
		LocalColocateControllerBuilder {

	LocalRandomColocateControllerBuilder(Game game) {
		super(game);
	}

	@Override
	void build() {
		this.build(new LocalRandomCoordinateController(game));
	}
}
