package ticTacToe.views;

import ticTacToe.models.Coordinate;
import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.RandomCoordinateController;
import ticTacToe.controllers.UserCoordinateController;

class PutTargetCoordinateView extends ColocateCoordinateView {

	private Coordinate target;

	PutTargetCoordinateView(CoordinateController coordinateController) {
		super(coordinateController);
	}		
		
	Coordinate getCoordinate(){
		target = this.getCoordinateController().getTarget();
		this.getCoordinateController().accept(this);
		return target;
	}

	@Override
	public void visit(UserCoordinateController userCoordinateController) {
		CoordinateView.instance().read("select", target);
	}

	@Override
	public void visit(RandomCoordinateController randomCoordinateController) {
		this.show("put in", target);
	}

}
