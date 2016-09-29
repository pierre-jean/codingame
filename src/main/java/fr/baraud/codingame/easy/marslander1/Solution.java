package fr.baraud.codingame.easy.marslander1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Solution {

    public static void solve(InputStream in, OutputStream out) {
        Scanner inputScanner = new Scanner(in);
        Landscape marsLandscape = Builder.buildLandscape().fromMars().fromScanner(inputScanner).build();
        Lander lander = Builder.buildLander().fromScanner(inputScanner).build();
        while (lander.hasLanded() == false ){
            Instruction instruction = lander.getInstructionToLandOn(marsLandscape);
            print(instruction, out);
            lander = Builder.buildLander().fromScanner(inputScanner).build();
        }
    }

    private static void print(Instruction instruction, OutputStream out) {
    }
}
