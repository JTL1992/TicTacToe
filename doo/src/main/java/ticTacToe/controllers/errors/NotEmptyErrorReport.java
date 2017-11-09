package ticTacToe.controllers.errors;

import java.util.List;

import ticTacToe.models.Coordinate;

public class NotEmptyErrorReport extends ErrorReport {

	public NotEmptyErrorReport(List<Coordinate> coordinateList) {
		super(coordinateList);
	}
	
	@Override
	public void accept(ErrorReportVisitor errorReportVisitor) {
		errorReportVisitor.visit(this);
	}
}
