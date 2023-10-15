package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int KAPREKARS_CONSTANT = 6174;

    private Task6() {
    }

    @SuppressWarnings("MagicNumber") //
    public static int countK(int input) {

        if (9999 < input || input < 1001) {
            return -1;
        }
        if (input == KAPREKARS_CONSTANT) {
            return 0;
        }
        int x = input;
        int[] digitArray = new int[4];
        for (int i = 0; i < 4; i++) {
            digitArray[i] = x % 10;
            x /= 10;
        }
        Arrays.sort(digitArray);
        int minNum = 0;
        int maxNum = 0;
        for (int i = 0; i < 4; i++) {
            minNum = minNum * 10 + digitArray[i];
            maxNum = maxNum * 10 + digitArray[4 - i - 1];
        }
        int output = countK(maxNum - minNum);
        if (output == -1) {
            return -1;
        } else {
            return output + 1;
        }
    }
}
