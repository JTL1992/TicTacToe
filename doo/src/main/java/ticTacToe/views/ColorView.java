package ticTacToe.views;

import ticTacToe.models.Color;
import ticTacToe.utils.IO;

class ColorView {

	private static ColorView colorView;

	public static ColorView instance() {
		if (colorView == null) {
			colorView = new ColorView();
		}
		return colorView;
	}

	private static final char[] COLORS = { 'x', 'o', '·' };

	private ColorView() {
	}

	void write(String title, Color color) {
		IO.instance().write(title + this.toChar(color));
	}

	void writeln(String title, Color color) {
		this.write(title, color);
		IO.instance().writeln();
	}

	void writeTurn(String title, Color color){
		IO.instance().write(title + this.toChar(color) + " turns, ");
	}

	void writeWinner(Color color) {
		String victory = "Victory!!!! ";
		IO.instance().write(victory);
		final int MAX = 3;
		for (int i = 0; i < MAX; i++) {
			IO.instance().write(this.toChar(color) + "! ");
		}
		IO.instance().writeln(victory);
	}

	void writeDraw(){
		IO.instance().writeln("X and O Draw!!!");
	}

	private char toChar(Color color) {
		return COLORS[color.ordinal()];
	}
}
