package ticTacToe.controllers.errors;

import ticTacToe.models.Game;

public class NotEmptyErrorReportFactory extends ErrorReportFactory {

	@Override
	public ErrorReport getErrorReport(Game game) {
		return new NotEmptyErrorReport(game.emptyCoordinates());
	}
	
}
