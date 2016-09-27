package fr.baraud.codingame.easy.defibrillators;

public class Defibrillator {

    static final Defibrillator NO_VALUE = new Defibrillator("No defibrillator available");

    private final String name;

    private Defibrillator(String name){
        this.name = name;
    }


    public String name() {
        return name;
    }

    public double distanceTo(User user) {
        return 0;
    }

    public static class BuildNew {

        public BuildNew fromText(String s) {
            return this;
        }

        public Defibrillator build() {
            return new Defibrillator("");
        }
    }
}
