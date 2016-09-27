package fr.baraud.codingame.easy.defibrillators;

import java.io.InputStream;
import java.util.*;

public class DefibrillatorDirectory {

    private final List<Defibrillator> availableDefibrillators;

    private DefibrillatorDirectory(List<Defibrillator> availableDefibrillators) {
        this.availableDefibrillators = availableDefibrillators;
    }

    public Defibrillator getClosestTo(User user) {
        Iterator<Defibrillator> defibrillatorIterator = availableDefibrillators.iterator();
        Defibrillator closestDefibrillator = defibrillatorIterator.next();
        while (defibrillatorIterator.hasNext()){
            Defibrillator defibrillator = defibrillatorIterator.next();
            if (defibrillator.distanceTo(user) < closestDefibrillator.distanceTo(user)){
                closestDefibrillator = defibrillator;
            }
        }
        return closestDefibrillator;
    }

    public static class BuildNew {
        List<Defibrillator> availableDefibrillators = Arrays.asList(Defibrillator.NO_VALUE);

        public BuildNew fromStream(InputStream in) {
            Scanner scanner = new Scanner(in);
            scanner.nextLine();
            scanner.nextLine();
            int numberOfDefibrillators = scanner.nextInt();
            scanner.nextLine();
            availableDefibrillators = new ArrayList<>();
            for (int i=0; i< numberOfDefibrillators; i++){
                Defibrillator defibrillator = new Defibrillator.BuildNew().fromText(scanner.nextLine()).build();
                availableDefibrillators.add(defibrillator);
            }
            return this;
        }

        public DefibrillatorDirectory build() {
            return new DefibrillatorDirectory(availableDefibrillators);
        }
    }
}
