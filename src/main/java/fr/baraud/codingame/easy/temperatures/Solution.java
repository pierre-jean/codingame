package fr.baraud.codingame.easy.temperatures;

public class Solution {

    public static void main(String args[]) {
        Temperatures temps = Temperatures.fromStream(System.in);
        System.out.println(temps.closestToZero());
    }

}
