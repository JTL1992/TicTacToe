package ticTacToe.controllers.local;

import ticTacToe.controllers.ContinueController;
import ticTacToe.controllers.OperationControllerVisitor;
import ticTacToe.models.Game;
import ticTacToe.models.Observer;
import ticTacToe.models.Subject;

public class LocalContinueController extends LocalOperationController implements
		ContinueController {

	private Subject subject;
	
	public LocalContinueController(Observer observer, Game game) {
		super(game);
		game.reset();
		subject = new Subject();
		subject.register(observer);
	}

	public void resume(boolean another) {
		if (another) {
			this.clear();
			subject.initialize();
		} else {
			subject.exit();
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
