package fr.baraud.codingame.easy.mimetype;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MimeTypeResolver {
    private static final String UNKNOWN = "UNKNOWN";

    private final Map<String, String> mimeTypes;

    private MimeTypeResolver(Map<String, String> mimeTypes){
        this.mimeTypes = mimeTypes;
    }

    String resolveTypeOf(File file) {
        String type = mimeTypes.get(file.extension().toUpperCase());
        return type != null ? type : UNKNOWN;
    }

    static class BuildNew {
        MimeTypeResolver fromStream(InputStream typeInputStream) {
            Map<String, String> mimeTypes = new HashMap<>();
            Scanner scanner = new Scanner(typeInputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String extension = line.split(" ")[0].toUpperCase();
                String type = line.split(" ")[1];
                mimeTypes.put(extension, type);
            }
            return new MimeTypeResolver(mimeTypes);
        }
    }
}
