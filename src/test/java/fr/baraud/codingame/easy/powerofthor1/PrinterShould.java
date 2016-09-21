package fr.baraud.codingame.easy.powerofthor1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PrinterShould {

    @Test
    public void printAndAddLineReturn() {
        OutputStream outputStream = new ByteArrayOutputStream();
        Printer printer = new Printer(outputStream);
        printer.print("Hello");
        printer.print("World");
        assertThat(outputStream.toString(), is(equalTo(String.format("Hello%nWorld%n"))));
    }

}
