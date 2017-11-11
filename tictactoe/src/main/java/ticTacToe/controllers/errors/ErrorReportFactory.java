package ticTacToe.controllers.errors;

import ticTacToe.models.Game;

public abstract class ErrorReportFactory {

	public abstract ErrorReport getErrorReport(Game game);

}
