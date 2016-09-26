package fr.baraud.codingame.easy.mimetype;

class File {

    private final String name;
    private final String extension;

    private File(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public String extension() {
        return extension;
    }

    public static class BuildNew {

        public File fromName(String fileName) {
            String[] fileAndExtension = fileName.split("\\.");
            if (fileAndExtension.length > 1){
                String extension = fileAndExtension[fileAndExtension.length-1].toUpperCase();
                String name = fileName.substring(0, fileName.length() - fileAndExtension.length - 2);
                return new File(name, extension);
            }
            return  new File(fileName, "");
        }
    }
}
