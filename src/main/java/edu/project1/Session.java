package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final int maxAttempts;
    private int usedAttempts = 0;
    private final String word;
    private final char[] currentWord;

    public Session(@NotNull String word, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.word = word;
        currentWord = new char[word.length()];
        Arrays.fill(currentWord, '*');
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getUsedAttempts() {
        return usedAttempts;
    }

    public String getWord() {
        return word;
    }

    public String getCurrentWord() {
        return new String(this.currentWord);
    }

    public boolean guess(char letter) {
        if (word.indexOf(letter) != -1) {
            int i = 0;
            do {
                i = word.indexOf(letter, i);
                if (i == -1) {
                    break;
                }
                currentWord[i] = letter;
                i++;
            } while (i < word.length());
            return true;
        } else {
            usedAttempts++;
            return false;
        }
    }

    public boolean thisIsVictory() {
        return this.getCurrentWord().equals(word);
    }

    public boolean thisIsDefeat() {
        return usedAttempts >= maxAttempts;
    }
}
