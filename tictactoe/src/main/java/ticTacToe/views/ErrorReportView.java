package ticTacToe.views;

import java.util.Iterator;

import ticTacToe.controllers.errors.ErrorReport;
import ticTacToe.controllers.errors.NotEmptyErrorReport;
import ticTacToe.models.Coordinate;
import ticTacToe.controllers.errors.ErrorReportVisitor;
import ticTacToe.utils.IO;

class ErrorReportView implements ErrorReportVisitor {

	public void write(ErrorReport errorReport) {
		errorReport.accept(this);
	}

	@Override
	public void visit(NotEmptyErrorReport notEmptyErrorReport) {
		this.write("Invalid coordinate, it's taken", notEmptyErrorReport);
	}

	private void write(String message, ErrorReport errorReport) {
		String separator = message + ". You can choose: ";
		Iterator<Coordinate> coordinateIterator = errorReport.iterator();
		while (coordinateIterator.hasNext()){
			CoordinateView.instance().write(separator, coordinateIterator.next());
			if (!separator.equals(", ")) {
				separator = ", ";
			}
		}
		IO.instance().writeln();
	}

}
