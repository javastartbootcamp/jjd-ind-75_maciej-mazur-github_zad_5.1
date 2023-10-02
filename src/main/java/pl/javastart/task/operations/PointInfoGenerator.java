package pl.javastart.task.operations;

import pl.javastart.task.model.Point;

public class PointInfoGenerator {
    public String getInfo(Point point) {
        int x = point.getX();
        int y = point.getY();
        int quarterAssessment = assessQuarter(x, y);

        return switch (quarterAssessment) {
            case 1, 2, 3, 4 -> quarterInfo(point, quarterAssessment);
            case 5 -> "Punkt (" + point.getX() + ", " + point.getY() + ") leży na osi X";
            case 6 -> "Punkt (" + point.getX() + ", " + point.getY() + ") leży na osi Y";
            case 7 -> "Punkt (" + point.getX() + ", " + point.getY() + ") leży na środku układu współrzędnych";
            default -> "Błąd wczytanych współrzędnych";
        };
    }

    private String quarterInfo(Point point, int quarterNumber) {
        String romanQuarterNumber = "";

        if (quarterNumber == 1) {
            romanQuarterNumber = "I";
        } else if (quarterNumber == 2) {
            romanQuarterNumber = "II";
        } else if (quarterNumber == 3) {
            romanQuarterNumber = "III";
        } else if (quarterNumber == 4) {
            romanQuarterNumber = "IV";
        }

        return "Punkt (" + point.getX() + ", " + point.getY() + ") leży w " + romanQuarterNumber
                + " ćwiartce układu współrzędnych";
    }

    private int assessQuarter(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else if (x != 0 && y == 0) {
            return 5;
        } else if (x == 0 && y != 0) {
            return 6;
        } else {
            return 7;    // gdy x == 0 i y == 0
        }
    }
}
