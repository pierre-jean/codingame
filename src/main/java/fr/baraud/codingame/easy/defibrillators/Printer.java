package fr.baraud.codingame.easy.defibrillators;

import java.io.IOException;
import java.io.OutputStream;

class Printer {

    private final OutputStream out;

    Printer(OutputStream out) {
        this.out = out;
    }

    public void print(String message) {
        try {
            tryToWrite(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryToWrite(String message) throws IOException {
        out.write(String.format("%s%n", message).getBytes());
    }

    public static class BuildNew {
        private OutputStream out = System.out;

        public BuildNew withOutput(OutputStream out) {
            this.out = out;
            return this;
        }

        public Printer build() {
            return new Printer(out);
        }
    }
}
