package pl.javastart.task;

import pl.javastart.task.model.Point;
import pl.javastart.task.operations.PointInfoGenerator;

import java.util.Scanner;

public class CoordinateSystem {

    // uzupełnij metodę. Używaj scannera przekazanego w parametrze.
    void run(Scanner scanner) {
        //System.out.println("Punkt (5, -3)");
        Point point = createPoint(scanner);
        PointInfoGenerator pointInfoGenerator = new PointInfoGenerator();
        System.out.println(pointInfoGenerator.getInfo(point));
    }

    private Point createPoint(Scanner scanner) {
        System.out.println("Podaj X");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj Y");
        int y = scanner.nextInt();
        scanner.nextLine();
        return new Point(x, y);
    }
}
