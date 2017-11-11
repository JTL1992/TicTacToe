package ticTacToe.models;

public class Subject {

	private Observer observer;
	
	public void register(Observer observer) {
		this.observer = observer;
	}
	
	public void initialize() {
		observer.initialize();
	}
	
	public void begin() {
		observer.begin();
	}
	
	public void end() {
		if (observer != null)
			observer.end();
	}
	
	public void exit() {
		observer.exit();
	}
}
