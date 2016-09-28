package fr.baraud.codingame.easy.defibrillators;

import java.util.*;

class DefibrillatorDirectory {

    private final List<Defibrillator> availableDefibrillators;

    private DefibrillatorDirectory(List<Defibrillator> availableDefibrillators) {
        this.availableDefibrillators = availableDefibrillators;
    }

    Defibrillator getClosestTo(User user) {
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
        List<Defibrillator> availableDefibrillators = new ArrayList<>();

        BuildNew fromScanner(Scanner scanner) {
            int numberOfDefibrillators = scanner.nextInt();
            scanner.nextLine();
            for (int i=0; i< numberOfDefibrillators; i++){
                Defibrillator defibrillator = new Defibrillator.BuildNew().fromScanner(scanner).build();
                availableDefibrillators.add(defibrillator);
            }
            return this;
        }

        BuildNew addDefibrillator(Defibrillator defibrillator) {
            availableDefibrillators.add(defibrillator);
            return this;
        }

        public DefibrillatorDirectory build() {
            return new DefibrillatorDirectory(availableDefibrillators);
        }
    }
}
