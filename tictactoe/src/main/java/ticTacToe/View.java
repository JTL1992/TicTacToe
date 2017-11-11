package ticTacToe;

import ticTacToe.controllers.OperationController;
import ticTacToe.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

	public void interact(OperationController operationController);
}
