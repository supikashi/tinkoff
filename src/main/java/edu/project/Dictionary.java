package edu.project;

import java.util.Random;

public class Dictionary {
    private static final String[] DICTIONARY = {"university", "watermelon", "java"};
    private static final Random RANDOM = new Random();

    public String getRandomWord() {
        return DICTIONARY[RANDOM.nextInt(DICTIONARY.length)];
    }
}
