package fr.baraud.codingame.easy.defibrillators;

import java.io.InputStream;
import java.util.Scanner;

public class User {
    public static class BuildNew {

        public BuildNew fromStream(InputStream in) {

            return this;
        }

        public User build(){
            return new User();
        }
    }
}
