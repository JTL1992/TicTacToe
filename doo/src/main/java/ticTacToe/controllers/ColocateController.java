package ticTacToe.controllers;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.controllers.errors.ErrorReport;

public interface ColocateController extends OperationController,
		PresenterController {

	Color take();

	void put(Coordinate target);

	boolean existTicTacToe();

	boolean complete();

	CoordinateController getCoordinateController();
	
	ErrorReport validateTarget(Coordinate target);

	void accept(ColocateControllerVisitor colocateControllerVisitor);
}
