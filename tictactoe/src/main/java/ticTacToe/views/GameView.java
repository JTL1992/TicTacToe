package ticTacToe.views;

import ticTacToe.controllers.ColocateController;
import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.controllers.ColocateControllerVisitor;
import ticTacToe.controllers.PutController;
import ticTacToe.controllers.errors.ErrorReport;

class GameView implements ColocateControllerVisitor {

	private BoardView boardView;
	
	private ErrorReportView errorReportView;
	
	private Coordinate origin;
	
	GameView(BoardView boardView) {
		assert boardView != null;
		this.boardView = boardView;
		errorReportView = new ErrorReportView();
	}

	void interact(ColocateController colocateController) {
		colocateController.accept(this);
	}

	@Override
	public void visit(PutController putController) {
		this.showTitle("", putController.take());
		PutTargetCoordinateView putCoordinateView = new PutTargetCoordinateView(
				putController.getCoordinateController());
		this.put(putController, putCoordinateView);
		this.showGame(putController);
	}

	private void showTitle(String title, Color color) {
		ColorView.instance().writeTurn("the player ", color);
	}

	private void put(PutController putController,
			ColocateCoordinateView colocateCoordinateView) {
		Coordinate target;
		ErrorReport errorReport = null;
		do {
			target = colocateCoordinateView.getCoordinate();
			errorReport = putController.validateTarget(target);
			if (errorReport != null) {
				errorReportView.write(errorReport);
			}
		} while (errorReport != null);
		putController.put(target);
	}

	private void showGame(ColocateController colocateController) {
		boardView.write(colocateController);
		if (colocateController.existTicTacToe()) {
			ColorView.instance().writeWinner(colocateController.take());
		} else if (colocateController.complete()){
			ColorView.instance().writeDraw();
		}
	}

}
