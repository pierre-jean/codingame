package fr.baraud.codingame.easy.mimetype;

class File {
    private final String extension;

    private File(String extension) {
        this.extension = extension;
    }

    String extension() {
        return extension;
    }

    static class BuildNew {

        File fromName(String fileNameWithExtension) {
            String[] fileNameSplitByDot = fileNameWithExtension.split("\\.");
            if (noDot(fileNameSplitByDot) || emptyExtension(fileNameWithExtension)){
                return new File("");
            }
            return new File(fileNameSplitByDot[fileNameSplitByDot.length - 1].toUpperCase());
        }

        private boolean noDot(String[] fileNameSplitByDot) {
            return fileNameSplitByDot.length == 1 ;
        }

        private boolean emptyExtension(String fileName){
            char lastChar = fileName.charAt(fileName.length()-1);
            return lastChar == '.';
        }


    }
}
