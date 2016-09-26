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

    public List<File> getAllFiles() {
        return files;
    }

    public static class BuildNew {
        public FileElements fromStream(InputStream fileListingInputStream) {
            Scanner scanner = new Scanner(fileListingInputStream);
            List<File> files = new ArrayList<>();
            while(scanner.hasNextLine()){
                files.add(new File.BuildNew().fromName(scanner.nextLine()));
            }
            return new FileElements(files);
        }
    }
}
