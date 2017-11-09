package ticTacToe.controllers.local;

import ticTacToe.controllers.OperationController;
import ticTacToe.controllers.OperationControllerVisitor;
import ticTacToe.models.Game;

public abstract class LocalOperationController extends LocalController
		implements OperationController {

	protected LocalOperationController(Game game) {
		super(game);
	}
	
	public abstract void accept(
			OperationControllerVisitor operationControllerVisitor);

}
