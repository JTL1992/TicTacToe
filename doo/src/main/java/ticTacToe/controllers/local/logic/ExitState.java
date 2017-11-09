package ticTacToe.controllers.local.logic;

import ticTacToe.controllers.local.LocalOperationController;

class ExitState extends State {

	ExitState(StatesBuilder statesBuilder){
		super(statesBuilder);
	}
	
	@Override
	LocalOperationController getOperationController() {
		return null;
	}

}
