package ticTacToe.controllers.errors;

import ticTacToe.models.Game;

public enum ErrorGeneratorType {

	NOT_EMPTY(new NotEmptyErrorReportFactory());

	private ErrorReportFactory errorReportFactory;
	
	private ErrorGeneratorType(ErrorReportFactory errorReportFactory){
		this.errorReportFactory = errorReportFactory;
	}
	
	public ErrorReport getErrorReport(Game game) {
		return errorReportFactory.getErrorReport(game);
	}
}
