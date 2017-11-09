package ticTacToe.views;

import ticTacToe.models.Coordinate;
import ticTacToe.utils.ChooseCoordinateDialog;
import ticTacToe.utils.IO;

class CoordinateView {

	private static CoordinateView coordinateView;
	
	public static CoordinateView instance() {
		if (coordinateView == null) {
			coordinateView = new CoordinateView();
		}
		return coordinateView;
	}
	
	private CoordinateView() {
		
	}
	
	void read(String title, Coordinate coordinate) {
		assert title != null;
		assert coordinate != null;
//		IO.instance().writeln();
		int[] selectedCoordiantion = ChooseCoordinateDialog.instance().read(title + " the coordinates");
		coordinate.setRow(selectedCoordiantion[0]);
		coordinate.setColumn(selectedCoordiantion[1]);
	}

	void write(String title, Coordinate coordinate) {
		assert title != null;
		assert coordinate != null;
		IO.instance().write(
				title + "[" + (coordinate.getRow()) + ", "
						+ (coordinate.getColumn()) + "]");

	}
}
