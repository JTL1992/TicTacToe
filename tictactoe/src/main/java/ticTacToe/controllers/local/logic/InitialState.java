package ticTacToe.controllers.local.logic;

import ticTacToe.controllers.local.LocalOperationController;
import ticTacToe.controllers.local.LocalOperationControllerBuilder;
import ticTacToe.controllers.local.LocalStartController;

class InitialState extends State {

	private LocalStartController localStartController;
	
	InitialState(StatesBuilder statesBuilder, LocalOperationControllerBuilder localOperationControllerBuilder){
		super(statesBuilder);
		localStartController = localOperationControllerBuilder.getStartController();
	}
	
	@Override
	State begin() {
		return statesBuilder.getInGameState();
	}
		
	@Override
	LocalOperationController getOperationController() {
		return localStartController;
	}

}
