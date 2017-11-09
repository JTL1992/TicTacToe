package ticTacToe.controllers.local.logic;

import ticTacToe.controllers.local.LocalContinueController;
import ticTacToe.controllers.local.LocalOperationController;
import ticTacToe.controllers.local.LocalOperationControllerBuilder;

class FinalState extends State {

	private LocalContinueController localContinueController;

	FinalState(StatesBuilder statesBuilder,
			LocalOperationControllerBuilder localOperationControllerBuilder) {
		super(statesBuilder);
		localContinueController = localOperationControllerBuilder
				.getContinueController();
	}

	@Override
	State initialize() {
		return statesBuilder.getInitialState();
	}
	
	@Override
	State exit() {
		return statesBuilder.getExitState();
	}

	@Override
	LocalOperationController getOperationController() {
		return localContinueController;
	}

}
