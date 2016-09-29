package fr.baraud.codingame.easy.marslander1;

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
            return new Landscape();
        }
    }

    public static class LanderBuilder {
        public LanderBuilder fromScanner(Scanner inputScanner) {
            return this;
        }

        public LanderBuilder fromMars(){
            return this;
        }

        public Lander build(){
            return new Lander();
        }
    }
}
