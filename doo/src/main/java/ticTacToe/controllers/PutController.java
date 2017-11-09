package ticTacToe.controllers;

import ticTacToe.controllers.errors.ErrorReport;
import ticTacToe.models.Coordinate;

public interface PutController extends ColocateController {

	ErrorReport validateTarget(Coordinate target);

}
