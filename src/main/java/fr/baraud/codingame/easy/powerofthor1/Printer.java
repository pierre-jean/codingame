package fr.baraud.codingame.easy.powerofthor1;

import java.io.IOException;
import java.io.OutputStream;

public class Printer {
    private OutputStream outputStream;

    public Printer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(String message) {
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
