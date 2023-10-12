package edu.hw1;

public class Task1 {

    private Task1() {
    }

    public static int minutesToSeconds(String string) {
        String[] stringArray = string.split(":");
        if (stringArray.length != 2 || stringArray[1].length() != 2) {
            return -1;
        }
        int x1 = Integer.parseInt(stringArray[0]);
        int x2 = Integer.parseInt(stringArray[1]);
        return 60 * x1 + x2;
    }
}
