package edu.hw1;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String str) {

        String[] strArray = str.split(":");
        int minutes = Integer.parseInt(strArray[0]);
        int seconds = Integer.parseInt(strArray[1]);
        if (seconds >= SECONDS_IN_MINUTE || strArray[1].length() != 2) {
            return -1;
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
