package fr.baraud.codingame.easy.mimetype;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileElements {

    private final List<File> files;

    private FileElements(List<File> files){
        this.files = files;
    }

    List<File> getAllFiles() {
        return files;
    }

    static class BuildNew {
        FileElements fromStream(InputStream fileListingInputStream) {
            Scanner scanner = new Scanner(fileListingInputStream);
            List<File> files = new ArrayList<>();
            while(scanner.hasNextLine()){
                files.add(new File.BuildNew().fromName(scanner.nextLine()));
            }
            return new FileElements(files);
        }
    }
}
