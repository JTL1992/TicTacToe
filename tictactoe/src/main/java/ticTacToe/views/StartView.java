package ticTacToe.views;

import ticTacToe.controllers.StartController;
import ticTacToe.utils.LimitedIntDialog;

class StartView {

	private BoardView boardView;
	
	StartView(BoardView boardView) {
		this.boardView = boardView;
	}
	
	void interact(StartController startController){
		int users = LimitedIntDialog.instance().read("How many players will play the game?", 0, 2);
		startController.start(users);
		boardView.write(startController);
	}
}
