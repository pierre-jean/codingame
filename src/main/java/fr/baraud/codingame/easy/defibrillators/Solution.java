package fr.baraud.codingame.easy.defibrillators;

import java.io.InputStream;
import java.io.OutputStream;

public class Solution {

    private final Printer printer;
    private final DefibrillatorDirectory defibrillatorsDirectory;
    private final User user;

    private Solution(DefibrillatorDirectory defibrillatorsDirectory, User user, Printer printer) {
        this.printer = printer;
        this.defibrillatorsDirectory = defibrillatorsDirectory;
        this.user = user;
    }

    public static void solve(InputStream in, OutputStream out) {
        User user = new User.BuildNew().fromStream(in).build();
        DefibrillatorDirectory defibrillatorDirectory = new DefibrillatorDirectory.BuildNew().fromStream(in).build();
        Printer printer = new Printer.BuildNew().withOutput(out).build();
        Solution solution = new Solution.BuildNew()
                .withUser(user)
                .withDefibrillatorDirectory(defibrillatorDirectory)
                .withPrinter(printer)
                .build();
        solution.solve();
    }

    private void solve() {
        Defibrillator closestToUser = defibrillatorsDirectory.getClosestTo(user);
        print(closestToUser.name());
    }

    private void print(String message){
        printer.print(message);
    }

    private static class BuildNew {
        private Printer printer = new Printer.BuildNew().build();
        private DefibrillatorDirectory defibrillatorsDirectory = new DefibrillatorDirectory.BuildNew().build();
        private User user = new User.BuildNew().build();

        public BuildNew withUser(User user) {
            this.user = user;
            return this;
        }

        public BuildNew withDefibrillatorDirectory(DefibrillatorDirectory defibrillatorDirectory) {
            this.defibrillatorsDirectory = defibrillatorDirectory;
            return this;
        }

        public BuildNew withPrinter(Printer printer) {
            this.printer = printer;
            return this;
        }

        public Solution build() {
            return new Solution(defibrillatorsDirectory, user, printer);
        }
    }
}
