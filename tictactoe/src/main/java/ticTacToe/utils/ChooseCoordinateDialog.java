package ticTacToe.utils;

public class ChooseCoordinateDialog {

    private static ChooseCoordinateDialog chooseCoordinateDialog;

    public static ChooseCoordinateDialog instance() {
        if (chooseCoordinateDialog == null) {
            chooseCoordinateDialog = new ChooseCoordinateDialog();
        }
        return chooseCoordinateDialog;
    }

    private ChooseCoordinateDialog() {

    }

    private boolean isValid(String s) {
        int row, column;
        int[] array;
        ClosedInterval closedInterval = new ClosedInterval(0, ticTacToe.models.Coordinate.DIMENSION);
        try {
            array = parseString(s);
            row = array[0];
            column = array[1];
        } catch (Exception e) {
            IO.instance().writeln("Bad format! should be for example: 1,2");
            return false;
        }
        return closedInterval.includes(row) && closedInterval.includes(column);
    }

    private int[] parseString(String s) {
        return new int[]{Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1])};
    }

    public int[] read(String title) {
        assert title != null;
        String coor;
        boolean ok;
        do {
            coor = IO.instance().readString(title + ": ");
            ok = this.isValid(coor);
            if (!ok) {
                IO.instance().writeln("Invalid coordinate");
            }
        } while (!ok);
        return this.parseString(coor);
    }
}
