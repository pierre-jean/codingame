package fr.baraud.codingame.easy.thebridge1;

public class Platform {

    private final int length;

    private Platform(int length){
        this.length = length;
    }

    public static class BuildNew {
        private int length = 1;

        public BuildNew atPosition(int position) {
            return this;
        }

        public BuildNew withLength(int length) {
            this.length = length;
            return this;
        }

        public Platform build() {
            return new Platform(length);
        }
    }

    public int length() {
        return length;
    }

}
