package ticTacToe.utils;

public class LimitedIntDialog {

    private static LimitedIntDialog limitedIntDialog;

    public static LimitedIntDialog instance() {
        if (limitedIntDialog == null) {
            limitedIntDialog = new LimitedIntDialog();
        }
        return limitedIntDialog;
    }

    private LimitedIntDialog() {

    }

    public int read(String title, int min, int max) {
        assert title != null;
        ClosedInterval limits = new ClosedInterval(min, max);
        ClosedIntervalView limitsView = new ClosedIntervalView(
                "Value should in", limits);
        int value;
        boolean ok;
        do {
            value = IO.instance().readInt(title + " " + limitsView + ": ");
            ok = limits.includes(value);
            if (!ok) {
                limitsView.writeln();
            }
        } while (!ok);
        return value;
    }
}
