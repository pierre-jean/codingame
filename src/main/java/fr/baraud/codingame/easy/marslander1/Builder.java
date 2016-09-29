package fr.baraud.codingame.easy.marslander1;

import java.util.Collections;
import java.util.Scanner;

public class Builder {

    public static LandscapeBuilder buildLandscape() {
        return new LandscapeBuilder();
    }

    public static LanderBuilder buildLander() {
        return new LanderBuilder();
    }

    public static class LandscapeBuilder {

        public LandscapeBuilder fromMars() {
            return this;
        }

        public LandscapeBuilder fromScanner(Scanner inputScanner){
            return this;
        }
        public Landscape build() {
            return new Landscape(Collections.emptyList(), new Gravity(0d));
        }

        public LandscapeBuilder addEdge(int x, int y) {
            return this;
        }
    }

    public static class LanderBuilder {
        private int x = 0;

        public LanderBuilder fromScanner(Scanner inputScanner) {
            x = inputScanner.nextInt();
            inputScanner.nextLine();
            return this;
        }

        public LanderBuilder fromMars(){
            return this;
        }

        public LanderBuilder atXCoord(int x) {
            this.x = x;
            return this;
        }

        public LanderBuilder atYCoord(int i) {
            return this;
        }

        public LanderBuilder atHorizontalSpeed(int i) {
            return this;
        }

        public LanderBuilder atVerticalSpeed(int i) {
            return this;
        }

        public LanderBuilder withFuelAmount(int i) {
            return this;
        }

        public LanderBuilder withRotation(int i) {
            return this;
        }

        public LanderBuilder withPower(int i) {
            return this;
        }

        public Lander build(){
            return new Lander(x,0,0,0,0,0,0);
        }
    }
}
