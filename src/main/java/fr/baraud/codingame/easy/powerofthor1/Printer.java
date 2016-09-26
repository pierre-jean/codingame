package fr.baraud.codingame.easy.powerofthor1;

import java.io.IOException;
import java.io.OutputStream;

class Printer {

    private OutputStream outputStream;

    Printer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    void print(String message) {
        try {
            tryToPrint(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryToPrint(String s) throws IOException {
        outputStream.write(String.format("%1$s%n", s).getBytes());
    }
}
