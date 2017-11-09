package ticTacToe.views;

import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.CoordinateControllerVisitor;
import ticTacToe.models.Coordinate;
import ticTacToe.utils.IO;

abstract class ColocateCoordinateView implements CoordinateControllerVisitor {

	private CoordinateController coordinateController;
	
	protected ColocateCoordinateView(CoordinateController coordinateController){
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}
	
	abstract Coordinate getCoordinate();
	
	protected void show(String infix, Coordinate coordinate){
		CoordinateView.instance().write("Robot " + infix + " ", coordinate);
		IO.instance().readString(". Click enter to continue");
	}
	
	protected CoordinateController getCoordinateController(){
		return coordinateController;
	}
}
