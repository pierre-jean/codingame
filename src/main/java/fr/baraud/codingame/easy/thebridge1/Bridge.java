package fr.baraud.codingame.easy.thebridge1;

public class Bridge {
    private final int position;
    private final int length;

    private Bridge(int position, int length){
        this.position = position;
        this.length = length;
    }

    public int length(){
        return this.length;
    }

    public static class BuildNew {
        private int position = 0;
        private int length = 0;


        public BuildNew atPosition(int position) {
            this.position = position;
            return this;
        }

        public BuildNew withLength(int length) {
            this.length = length;
            return this;
        }

        public Bridge build() {
            return new Bridge(position, length);
        }
    }
}
