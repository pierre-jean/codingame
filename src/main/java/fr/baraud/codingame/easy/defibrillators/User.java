package fr.baraud.codingame.easy.defibrillators;

import java.util.Scanner;

class User {

    private final Double longitude;
    private final Double latitude;

    private User(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    double longitude() {
        return longitude;
    }

    double latitude(){
        return latitude;
    }

    public static class BuildNew {
        private Double longitude = 0d;
        private Double latitude = 0d;

        BuildNew fromScanner(Scanner scanner) {
            this.longitude = readNextDoubleFrom(scanner);
            this.latitude = readNextDoubleFrom(scanner);
            return this;
        }

        BuildNew withLongitude(double longitude){
            this.longitude = longitude;
            return this;
        }

        BuildNew withLatitude(double latitude){
            this.latitude = latitude;
            return this;
        }

        private Double readNextDoubleFrom(Scanner scanner){
            return Double.valueOf(scanner.nextLine().replace(',','.'));
        }

        public User build(){
            return new User(longitude, latitude);
        }

    }
}
