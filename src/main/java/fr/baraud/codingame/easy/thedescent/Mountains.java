package fr.baraud.codingame.easy.thedescent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

class Mountains {

    private static final int NUMBER_OF_MOUNTAINS = 8;
    private static final int NO_MOUNTAIN = -1;

    private final int highestIndex;

    private Mountains(int highestIndex){
        this.highestIndex = highestIndex;
    }

    void tryToPrintBiggestMountain(OutputStream outputStream) throws IOException {
        outputStream.write(String.format("%1$d%n", highestIndex).getBytes());
    }

    static Mountains fromStream(InputStream input){
        Scanner scanner = new Scanner(input);
        int highestIndex = NO_MOUNTAIN;
        int highestAltitude = 0;
        for (int i = 0; i < NUMBER_OF_MOUNTAINS; i++){
            int altitude = scanner.nextInt();
            if (altitude > highestAltitude){
                highestIndex = i;
                highestAltitude = altitude;
            }
        }
        return Mountains.fromHighestIndex(highestIndex);
    }

    boolean areDestroyed(){
        return highestIndex == NO_MOUNTAIN;
    }

    private static Mountains fromHighestIndex(int mountainIndex){
        return new Mountains(mountainIndex);
    }
}
