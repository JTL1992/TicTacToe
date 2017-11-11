package ticTacToe.controllers.errors;

public interface ErrorReportVisitor {

	void visit(NotEmptyErrorReport notEmptyErrorReport);

}
