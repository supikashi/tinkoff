package edu.hw3.Task1;

public class Atbash {
    private static final char FIRST_LOWERCASE_LETTER = 'a';
    private static final char LAST_LOWERCASE_LETTER = 'z';
    private static final char FIRST_UPPERCASE_LETTER = 'A';
    private static final char LAST_UPPERCASE_LETTER = 'Z';

    private Atbash() {
    }

    public static String encryptViaAtbash(String str) {
        if (str == null) {
            return null;
        }
        char[] encoded = str.toCharArray();
        for (int i = 0; i < encoded.length; i++) {
            if (FIRST_LOWERCASE_LETTER <= encoded[i] && encoded[i] <= LAST_LOWERCASE_LETTER) {
                encoded[i] = (char) (LAST_LOWERCASE_LETTER - encoded[i] + FIRST_LOWERCASE_LETTER);
            } else if (FIRST_UPPERCASE_LETTER <= encoded[i] && encoded[i] <= LAST_UPPERCASE_LETTER) {
                encoded[i] = (char) (LAST_UPPERCASE_LETTER - encoded[i] + FIRST_UPPERCASE_LETTER);
            }
        }
        return new String(encoded);
    }
}
