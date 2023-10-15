package edu.hw1;

public class Task7 {

    private Task7() {
    }

    public static int rotateRight(int n, int shift) {

        int i = getBiggestBit(n);
        if (i == 0) {
            return 0;
        }
        int realShift = shift % i;
        return (n >> realShift) + ((n % (1 << realShift)) * (1 << (i - realShift)));
    }

    public static int rotateLeft(int n, int shift) {

        int i = getBiggestBit(n);
        if (i == 0) {
            return 0;
        }
        int realShift = shift % i;
        return ((n % (1 << (i - realShift))) << realShift) + (n / (1 << (i - realShift)));
    }

    private static int getBiggestBit(int x) {

        if (x == 0) {
            return 0;
        }
        int i = 1;
        while ((1 << i) <= x) {
            i++;
        }
        return i;
    }
}
