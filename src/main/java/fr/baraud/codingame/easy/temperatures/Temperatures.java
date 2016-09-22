package fr.baraud.codingame.easy.temperatures;

import java.io.InputStream;
import java.util.Scanner;

class Temperatures {

    private final int closestToZero;

    public Temperatures(int closestToZero){
        this.closestToZero = closestToZero;
    }

    public static Temperatures fromStream(InputStream in) {
        Scanner scanner = new Scanner(in);
        int numberOfMeasures = scanner.nextInt();
        scanner.nextLine();
        if (numberOfMeasures == 0){
            return new Temperatures(0);
        }
        int closestToZeroMeasured = scanner.nextInt();
        for (int i=1; i< numberOfMeasures; i++){
            int temperatureMeasure = scanner.nextInt();
            closestToZeroMeasured = closestToZeroTemperature(temperatureMeasure, closestToZeroMeasured);
        }
        return new Temperatures(closestToZeroMeasured);
    }

    private static int closestToZeroTemperature(int measure1, int measure2){
        if (Math.abs(measure1) == Math.abs(measure2)){
            return measure1 < measure2 ? measure2 : measure1;
        }
        return Math.abs(measure1) < Math.abs(measure2) ? measure1 : measure2;
    }

    int closestToZero() {
        return closestToZero;
    }
}
