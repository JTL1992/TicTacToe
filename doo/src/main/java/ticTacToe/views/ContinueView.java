package ticTacToe.views;

import ticTacToe.controllers.ContinueController;
import ticTacToe.utils.YesNoDialog;

class ContinueView {

	void interact(ContinueController continueController) {
		continueController.resume(YesNoDialog.instance()
				.read("Want to continue"));
	}
}
