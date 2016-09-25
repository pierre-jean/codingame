package fr.baraud.codingame.easy.mimetype;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionShould {

    @Test
    public void create_resolver_from_stream(){
        String entry = "2%n" +
                "4%n" +
                "html text/html%n" +
                "png image/png%n" +
                "test.html%n" +
                "noextension%n" +
                "portrait.png%n" +
                "doc.TXT%n";
        InputStream in = new ByteArrayInputStream(String.format(entry).getBytes());
        SolutionInputStream solutionInputStream = new SolutionInputStream(in);
        MimeTypeResolver mimeTypeResolver = new MimeTypeResolver.BuildNew()
                .fromStream(solutionInputStream.getMimeListingInputStream());
        FileElements files = new FileElements.BuildNew()
                .fromStream(solutionInputStream.getFileListingInputStream());
        OutputStream out = new ByteArrayOutputStream();
        for (File file : files.getAllFiles()){
            Printer printer = new Printer(out);
            printer.print(mimeTypeResolver.resolveTypeOf(file));
        }
    }

    @Test
    public void create_a_stream_only_for_mime(){
        String entry = "2%n" +
                "4%n" +
                "html text/html%n" +
                "png image/png%n" +
                "test.html%n" +
                "noextension%n" +
                "portrait.png%n" +
                "doc.TXT%n";
        InputStream in = new ByteArrayInputStream(String.format(entry).getBytes());
        SolutionInputStream solutionInputStream = new SolutionInputStream(in);
        InputStream mimeInputStream = solutionInputStream.getMimeListingInputStream();
        Scanner mimeScanner = new Scanner(mimeInputStream);
        assertThat(mimeScanner.nextLine(), is(equalTo("html text/html")));
        assertThat(mimeScanner.nextLine(), is(equalTo("png image/png")));
        assertThat(mimeScanner.hasNext(), is(false));
    }

    @Test
    public void create_a_stream_only_for_files(){
        String entry = "2%n" +
                "4%n" +
                "html text/html%n" +
                "png image/png%n" +
                "test.html%n" +
                "noextension%n" +
                "portrait.png%n" +
                "doc.TXT%n";
        InputStream in = new ByteArrayInputStream(String.format(entry).getBytes());
        SolutionInputStream solutionInputStream = new SolutionInputStream(in);
        InputStream filesInputStream = solutionInputStream.getFileListingInputStream();
        Scanner fileScanner = new Scanner(filesInputStream);
        assertThat(fileScanner.nextLine(), is(equalTo("test.html")));
        assertThat(fileScanner.nextLine(), is(equalTo("noextension")));
        assertThat(fileScanner.nextLine(), is(equalTo("portrait.png")));
        assertThat(fileScanner.nextLine(), is(equalTo("doc.TXT")));
        assertThat(fileScanner.hasNext(), is(false));
    }

    @Test
    public void resolve_type_html(){
        String entry = "2%n" +
                "4%n" +
                "html text/html%n" +
                "png image/png%n" +
                "test.html%n" +
                "noextension%n" +
                "portrait.png%n" +
                "doc.TXT%n";
        InputStream in = new ByteArrayInputStream(String.format(entry).getBytes());
        SolutionInputStream solutionInputStream = new SolutionInputStream(in);
        MimeTypeResolver mimeTypeResolver = new MimeTypeResolver.BuildNew()
                .fromStream(solutionInputStream.getMimeListingInputStream());
        File htmlFile = new File.BuildNew().fromName("test.html");
        assertThat(mimeTypeResolver.resolveTypeOf(htmlFile), is(equalTo("text/html")));
    }
}
