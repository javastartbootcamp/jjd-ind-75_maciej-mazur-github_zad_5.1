package pl.javastart.task.operations;

import pl.javastart.task.model.Point;

public class PointInfoGenerator {
    private static final int LOCATION_QUARTER_1 = 1;
    private static final int LOCATION_QUARTER_2 = 2;
    private static final int LOCATION_QUARTER_3 = 3;
    private static final int LOCATION_QUARTER_4 = 4;
    private static final int LOCATION_AXIS_X = 5;
    private static final int LOCATION_AXIS_Y = 6;
    private static final int LOCATION_CENTER = 7;

    public String getInfo(Point point) {
        int x = point.getX();
        int y = point.getY();
        int quarterAssessment = assessQuarter(x, y);

        return switch (quarterAssessment) {
            case LOCATION_QUARTER_1, LOCATION_QUARTER_2, LOCATION_QUARTER_3, LOCATION_QUARTER_4 -> quarterInfo(point, quarterAssessment);
            case LOCATION_AXIS_X -> point.print() + "na osi X";
            case LOCATION_AXIS_Y -> point.print() + "na osi Y";
            case LOCATION_CENTER -> point.print() + "na środku układu współrzędnych";
            default -> "Błąd wczytanych współrzędnych";
        };
    }

    private String quarterInfo(Point point, int quarterNumber) {
        String romanQuarterNumber = "";

        if (quarterNumber == LOCATION_QUARTER_1) {
            romanQuarterNumber = "I";
        } else if (quarterNumber == LOCATION_QUARTER_2) {
            romanQuarterNumber = "II";
        } else if (quarterNumber == LOCATION_QUARTER_3) {
            romanQuarterNumber = "III";
        } else if (quarterNumber == LOCATION_QUARTER_4) {
            romanQuarterNumber = "IV";
        }

        return point.print() + "w " + romanQuarterNumber
                + " ćwiartce układu współrzędnych";
    }

    private int assessQuarter(int x, int y) {
        if (x > 0 && y > 0) {
            return LOCATION_QUARTER_1;
        } else if (x < 0 && y > 0) {
            return LOCATION_QUARTER_2;
        } else if (x < 0 && y < 0) {
            return LOCATION_QUARTER_3;
        } else if (x > 0 && y < 0) {
            return LOCATION_QUARTER_4;
        } else if (x != 0 && y == 0) {
            return LOCATION_AXIS_X;
        } else if (x == 0 && y != 0) {
            return LOCATION_AXIS_Y;
        } else {
            return LOCATION_CENTER;    // gdy x == 0 i y == 0
        }
    }
}
