package edu.hw3.Task1;

public class Atbash {
    private Atbash() {
    }

    public static String atbash(String str) {
        if (str == null) {
            return null;
        }
        char[] encoded = str.toCharArray();
        for (int i = 0; i < encoded.length; i++) {
            if ('a' <= encoded[i] && encoded[i] <= 'z') {
                encoded[i] = (char) ('z' - encoded[i] + 'a');
            } else if ('A' <= encoded[i] && encoded[i] <= 'Z') {
                encoded[i] = (char) ('Z' - encoded[i] + 'A');
            }
        }
        return new String(encoded);
    }
}
