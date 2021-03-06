package fr.baraud.codingame.easy.mimetype;

import java.io.IOException;
import java.io.OutputStream;

class Printer {

    private OutputStream out;

    Printer(OutputStream out) {

        this.out = out;
    }

    void print(String line) {
        try {
            tryToPrint(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryToPrint(String line) throws IOException {
        out.write(String.format("%s%n",line).getBytes());
    }
}
