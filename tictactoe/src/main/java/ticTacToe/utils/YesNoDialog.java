package ticTacToe.utils;

public class YesNoDialog {

	private static YesNoDialog yesNoDialog;

	public static YesNoDialog instance() {
		if (yesNoDialog == null) {
			yesNoDialog = new YesNoDialog();
		}
		return yesNoDialog;
	}

	private YesNoDialog() {

	}

	public boolean read(String title) {
		assert title != null;
		char answer;
		boolean ok;
		do {
			answer = IO.instance().readChar(title + "? (y/n): ");
			ok = answer == 'y' || answer == 'Y' || answer == 'n'
					|| answer == 'N';
			if (!ok) {
				IO.instance().writeln("Choose 'y' or 'n'");
			}
		} while (!ok);
		return answer == 'y' || answer == 'Y';
	}
}
