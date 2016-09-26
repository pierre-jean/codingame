package fr.baraud.codingame.easy.thebridge1;

class Gap {
    private final int position;
    private final int length;

    private Gap(int position, int length){
        this.position = position;
        this.length = length;
    }

    int length(){
        return this.length;
    }

    int position() {
        return position;
    }

    static class BuildNew {
        private int position = 0;
        private int length = 0;


        BuildNew atPosition(int position) {
            this.position = position;
            return this;
        }

        BuildNew withLength(int length) {
            this.length = length;
            return this;
        }

        Gap build() {
            return new Gap(position, length);
        }
    }
}
