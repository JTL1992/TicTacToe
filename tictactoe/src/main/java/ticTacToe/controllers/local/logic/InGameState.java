package ticTacToe.controllers.local.logic;

import ticTacToe.controllers.local.LocalOperationController;
import ticTacToe.controllers.local.LocalOperationControllerBuilder;

class InGameState extends State {

	private LocalOperationControllerBuilder localOperationControllerBuilder;
	
	public InGameState(StatesBuilder statesBuilder,
			LocalOperationControllerBuilder localOperationControllerBuilder) {
		super(statesBuilder);
		this.localOperationControllerBuilder = localOperationControllerBuilder;
	}

	@Override
	State end() {
		return statesBuilder.getFinalState();
	}

	@Override
	public LocalOperationController getOperationController() {
		return localOperationControllerBuilder.getColocateController();
	}

}
