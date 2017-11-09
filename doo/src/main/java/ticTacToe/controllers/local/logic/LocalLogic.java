package ticTacToe.controllers.local.logic;

import ticTacToe.Logic;
import ticTacToe.controllers.local.LocalOperationController;
import ticTacToe.controllers.local.LocalOperationControllerBuilder;
import ticTacToe.models.Game;
import ticTacToe.models.Observer;

public class LocalLogic implements Logic, Observer {

	private StatesBuilder statesBuilder;

	private State actualState;

	public LocalLogic() {
		Game game = new Game(this);
		LocalOperationControllerBuilder localOperationControllerBuilder = new LocalOperationControllerBuilder(
				this, game);
		localOperationControllerBuilder.build();
		statesBuilder = new StatesBuilder(this, game,
				localOperationControllerBuilder);
		actualState = statesBuilder.getInitialState();
	}

	public void initialize() {
		actualState = actualState.initialize();
	}

	public void begin() {
		actualState = actualState.begin();
	}

	public void end() {
		actualState = actualState.end();
	}

	public void exit() {
		actualState = actualState.exit();
	}

	public LocalOperationController getOperationController() {
		return actualState.getOperationController();
	}

}
