package fr.baraud.codingame.easy.defibrillators;

import java.util.Objects;
import java.util.Scanner;

class Defibrillator {
    private final int id;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final double longitude;
    private final double latitude;

    private Defibrillator(int id, String name, String address, String phoneNumber, double longitude, double latitude){
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    String name() {
        return name;
    }

    double distanceTo(User user) {
        double x = (user.longitude() - this.longitude) * Math.cos((user.latitude() + this.latitude)/2);
        double y = user.latitude() - latitude;
        return Math.sqrt(Math.pow(x,2)+ Math.pow(y, 2)) * 6371;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj.getClass() != this.getClass()){
            return false;
        }
        Defibrillator other = (Defibrillator) obj;
        return
                Objects.equals(id, other.id)
                && Objects.equals(name, other.name)
                && Objects.equals(address, other.address)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(longitude, other.longitude)
                && Objects.equals(latitude, other.latitude);
    }

    @Override
    public int hashCode() {
        return
                Objects.hash(name, latitude, longitude);
    }

    public static class BuildNew {
        int id = 0;
        String name = "No Name";
        String address = "Not found";
        String phoneNumber = "";
        double longitude = 0d;
        double latitude = 0d;

        BuildNew fromScanner(Scanner scanner) {
            String[] input = scanner.nextLine().split(";");
            id = Integer.valueOf(input[0]);
            name = input[1];
            address = input[2];
            phoneNumber = input[3];
            longitude = Double.valueOf(input[4].replace(',','.'));
            latitude = Double.valueOf(input[5].replace(',','.'));
            return this;
        }

        BuildNew withLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        BuildNew withLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        BuildNew withName(String name) {
            this.name = name;
            return this;
        }

        BuildNew withPhone(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        BuildNew withAddress(String address) {
            this.address = address;
            return this;
        }

        BuildNew withId(int id) {
            this.id = id;
            return this;
        }

        public Defibrillator build() {
            return new Defibrillator(id, name, address, phoneNumber, longitude, latitude);
        }
    }
}
