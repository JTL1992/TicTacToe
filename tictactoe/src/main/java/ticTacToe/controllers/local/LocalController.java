package ticTacToe.controllers.local;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public abstract class LocalController {

	private Game game;

	protected LocalController(Game game) {
		assert game != null;
		this.game = game;
	}
	
	protected Game getGame() {
		return game;
	}
	
	protected int numPlayers() {
		return game.getNumPlayers();
	}
	
	public Color take() {
		return game.take();
	}
	
	public void put(Coordinate target) {
		assert target != null;
		game.put(target);
		if (!game.existTicTacToe()) {
			game.change();
		}
	}
	
	public void remove(Coordinate origin) {
		assert origin != null;
		game.remove(origin);
	}
	
	public void clear() {
		game.clear();		
	}	
	
	public boolean empty(Coordinate coordinate) {
		assert coordinate != null;
		return game.empty(coordinate);
	}
	
	public boolean full(Coordinate coordinate) {
		assert coordinate != null;
		return game.full(coordinate);
	}

	public boolean complete() {
		return game.complete();
	}
	
	public boolean existTicTacToe() {
		return game.existTicTacToe();
	}	
	
	public Color getColor(Coordinate coordinate){
		assert coordinate != null;
		return game.getColor(coordinate);
	}
	
}
