package edu.hw1;

public class Task4 {

    private Task4() {
    }

    public static String fixString(String str) {

        char[] charArray = str.toCharArray();
        char tmp;
        for (int i = 1; i < charArray.length; i += 2) {
            tmp = charArray[i - 1];
            charArray[i - 1] = charArray[i];
            charArray[i] = tmp;
        }
        return new String(charArray);
    }
}
