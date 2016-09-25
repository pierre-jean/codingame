package fr.baraud.codingame.easy.mimetype;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileElements {

    public List<File> getAllFiles() {
        return new ArrayList<>();
    }

    public static class BuildNew {
        public FileElements fromStream(InputStream fileListingInputStream) {
            return new FileElements();
        }
    }
}
