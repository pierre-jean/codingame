package fr.baraud.codingame.easy.thebridge1;

class Platform {

    private final int length;

    private Platform(int length){
        this.length = length;
    }

    static class BuildNew {
        private int length = 1;

        BuildNew atPosition(int position) {
            return this;
        }

        BuildNew withLength(int length) {
            this.length = length;
            return this;
        }

        Platform build() {
            return new Platform(length);
        }
    }

    int length() {
        return length;
    }

}
