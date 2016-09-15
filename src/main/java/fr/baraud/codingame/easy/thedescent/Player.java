package fr.baraud.codingame.easy.thedescent;

import java.io.IOException;
import java.io.OutputStream;

class Player {

    private OutputStream outputStream;

    Player(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    void shotBiggestMountain(Mountains mountains) {
        try {
            tryToShotBiggestMountain(mountains);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryToShotBiggestMountain(Mountains mountains) throws IOException {
        mountains.tryToPrintBiggestMountain(outputStream);
    }

    public static void main(String[] args){
        Player player = new Player(System.out);
        while (true){
            player.shotBiggestMountain(Mountains.fromStream(System.in));
        }
    }
}
