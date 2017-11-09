package ticTacToe;

import ticTacToe.controllers.OperationController;
import ticTacToe.controllers.local.logic.LocalLogic;
import ticTacToe.views.ConsoleView;

public class TicTacToe {

	private Logic logic;
	
	private View view;
	
	public TicTacToe() {
		this.view = this.getView();
		this.logic = this.getLogic();
	}
	
	protected Logic getLogic() {
		return new LocalLogic();
	}

	protected View getView() {
		return new ConsoleView();
	}

	public void play() {
		OperationController controller;
		do {
			controller = logic.getOperationController();
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
	}
	
}
