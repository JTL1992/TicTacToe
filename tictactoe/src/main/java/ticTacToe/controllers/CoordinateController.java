package ticTacToe.controllers;

import ticTacToe.models.Coordinate;

public interface CoordinateController {

	Coordinate getTarget();

	void accept(CoordinateControllerVisitor coordinateControllerVisitor);

}
