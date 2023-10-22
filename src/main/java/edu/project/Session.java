package edu.project;

import java.util.Arrays;

public class Session {
    private final int maxAttempts;
    private int currentAttempt = 1;
    private final String word;
    private final char[] currentWord;

    public Session(String word, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.word = word;
        currentWord = new char[word.length()];
        Arrays.fill(currentWord, '*');
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void nextAttempt() {
        this.currentAttempt++;
    }

    public String getWord() {
        return word;
    }

    public String getCurrentWord() {
        return new String(this.currentWord);
    }

    public void successfulGuess(char letter) {
        int i = 0;
        do {
            i = this.getWord().indexOf(letter, i);
            if (i == -1) {
                break;
            }
            currentWord[i] = letter;
            i++;
        } while (i < this.getWord().length());
    }
}
