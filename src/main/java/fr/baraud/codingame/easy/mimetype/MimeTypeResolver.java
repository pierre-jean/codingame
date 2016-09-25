package fr.baraud.codingame.easy.mimetype;

import java.io.InputStream;

public class MimeTypeResolver {

    public String resolveTypeOf(File file) {
        return "text/html";
    }

    public static class BuildNew {
        public MimeTypeResolver fromStream(InputStream typeInputStream) {
            return new MimeTypeResolver();
        }
    }
}
