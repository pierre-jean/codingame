package fr.baraud.codingame.easy.defibrillators;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

class Solution {

    private final Printer printer;
    private final DefibrillatorDirectory defibrillatorsDirectory;
    private final User user;

    private Solution(DefibrillatorDirectory defibrillatorsDirectory, User user, Printer printer) {
        this.printer = printer;
        this.defibrillatorsDirectory = defibrillatorsDirectory;
        this.user = user;
    }

    static void solve(InputStream in, OutputStream out) {
        Scanner scanner = new Scanner(in);
        User user = new User.BuildNew().fromScanner(scanner).build();
        DefibrillatorDirectory defibrillatorDirectory = new DefibrillatorDirectory.BuildNew().fromScanner(scanner).build();
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
        print(closestToUser != null ? closestToUser.name() : "No defibrillator found");
    }

    private void print(String message){
        printer.print(message);
    }

    private static class BuildNew {
        private Printer printer = new Printer.BuildNew().build();
        private DefibrillatorDirectory defibrillatorsDirectory = new DefibrillatorDirectory.BuildNew().build();
        private User user = new User.BuildNew().build();

        BuildNew withUser(User user) {
            this.user = user;
            return this;
        }

        BuildNew withDefibrillatorDirectory(DefibrillatorDirectory defibrillatorDirectory) {
            this.defibrillatorsDirectory = defibrillatorDirectory;
            return this;
        }

        BuildNew withPrinter(Printer printer) {
            this.printer = printer;
            return this;
        }

        public Solution build() {
            return new Solution(defibrillatorsDirectory, user, printer);
        }
    }
}
