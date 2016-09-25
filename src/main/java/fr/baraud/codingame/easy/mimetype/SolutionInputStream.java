package fr.baraud.codingame.easy.mimetype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class SolutionInputStream {

    byte[] mimeTypesInput;
    byte[] fileElementsInput;

    SolutionInputStream(InputStream in) {
        readMimeAndFileInput(in);
    }

    private void readMimeAndFileInput(InputStream in) {
        try {
            tryToReadMimeAndFileInput(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryToReadMimeAndFileInput(InputStream in) throws IOException {
        Scanner scanner = new Scanner(in);
        int numberOfMimeTypes = scanner.nextInt();
        scanner.nextLine();
        int numberOfFileElements = scanner.nextInt();
        scanner.nextLine();
        ByteArrayOutputStream mimeOut = new ByteArrayOutputStream();
        for (int i = 0; i< numberOfMimeTypes; i++){
            mimeOut.write(readLineOfBytes(scanner));
        }
        ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
        for (int i=0; i< numberOfFileElements; i++){
            fileOut.write(readLineOfBytes(scanner));
        }
        mimeTypesInput = mimeOut.toByteArray();
        fileElementsInput = fileOut.toByteArray();
    }

    private byte[] readLineOfBytes(Scanner scanner){
        String lineWithLineReturn = String.format("%s%n", scanner.nextLine());
        return lineWithLineReturn.getBytes();
    }

    InputStream getMimeListingInputStream() {
        return new ByteArrayInputStream(mimeTypesInput);
    }

    InputStream getFileListingInputStream(){
        return new ByteArrayInputStream(fileElementsInput);
    }
}
