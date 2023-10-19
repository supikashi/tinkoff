package edu.hw1;

public class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i : firstArray) {
            firstMax = Math.max(firstMax, i);
            firstMin = Math.min(firstMin, i);
        }
        for (int j : secondArray) {
            secondMax = Math.max(secondMax, j);
            secondMin = Math.min(secondMin, j);
        }
        return secondMin < firstMin && firstMax < secondMax;
    }
}
