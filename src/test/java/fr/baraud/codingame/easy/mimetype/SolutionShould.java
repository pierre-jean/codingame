package fr.baraud.codingame.easy.mimetype;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyString;
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
        assertThat(out.toString(), is(equalTo(String.format("text/html%nUNKNOWN%nimage/png%nUNKNOWN%n"))));
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
    public void create_file_with_extension_in_uppercase(){
        File pngFile = new File.BuildNew().fromName("landscape.png");
        assertThat(pngFile.extension(), is(equalTo("PNG")));
    }

    @Test
    public void filter_empty_extension(){
        File pngFile = new File.BuildNew().fromName(".mp3.");
        assertThat(pngFile.extension(), is(equalTo("")));
    }

    @Test public void accept_empty_filename_on_file_creation(){
        File onlyExtensionFile = new File.BuildNew().fromName(".png");
        assertThat(onlyExtensionFile.extension(), is(equalTo("PNG")));
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
        File pngFile = new File.BuildNew().fromName("portrait.png");
        assertThat(mimeTypeResolver.resolveTypeOf(pngFile), is(equalTo("image/png")));
        File noExtensionFile = new File.BuildNew().fromName("noextension");
        assertThat(mimeTypeResolver.resolveTypeOf(noExtensionFile), is(equalTo("UNKNOWN")));
    }

    @Test
    public void resolve_test_03(){
        String entry = "3%n" +
                "11%n" +
                "wav audio/x-wav%n" +
                "mp3 audio/mpeg%n" +
                "pdf application/pdf%n" +
                "a%n" +
                "a.wav%n" +
                "b.wav.tmp%n"+
                "test.vmp3%n"+
                "pdf%n"+
                ".pdf%n"+
                "mp3%n"+
                "report..pdf%n"+
                "defaultwav%n"+
                ".mp3.%n"+
                "final.%n";
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
        String expectedOutput = "UNKNOWN%n" +   //a
                "audio/x-wav%n" +   //a.wav
                "UNKNOWN%n" +   //b.wav.tmp
                "UNKNOWN%n" +   //test.vmp3
                "UNKNOWN%n" +   //pdf
                "application/pdf%n" +   //.pdf
                "UNKNOWN%n" +   //mp3
                "application/pdf%n" +   //report..pdf
                "UNKNOWN%n" +   //defaultwav
                "UNKNOWN%n" +   //.mp3.
                "UNKNOWN%n";    //final.
        assertThat(out.toString(), is(equalTo(String.format(expectedOutput))));
    }
}
