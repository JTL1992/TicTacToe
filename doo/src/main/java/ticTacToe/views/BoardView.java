package ticTacToe.views;

import ticTacToe.controllers.PresenterController;
import ticTacToe.models.Coordinate;
import ticTacToe.utils.IO;

class BoardView {

	void write(PresenterController controller) {
		assert controller != null;
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				ColorView.instance().write(" ", controller.getColor(new Coordinate(i, j)));
			}
			IO.instance().writeln();
		}
	}
}
