package ticTacToe.models;

import java.io.Serializable;

class Turn implements Serializable {

	private int value = 0;
	
	public Turn() {
		value = 0;
	}
	
    public Color take() {
        return Color.values()[value];
    }
    
    public void change() {
    	value = (value +1)% (Color.values().length-1);
    }
	
}