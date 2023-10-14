package edu.hw1;

public class Task3 {

    private Task3() {
    }

    @SuppressWarnings("MagicNumber") //
    public static int countDigits(int input) {
        int output = 1;
        int powerOfTen = 10;
        int num = input;
        if (num < 0) { //не знаю надо ли было это делать
            num *= -1;
        }
        while (powerOfTen <= num) {
            powerOfTen *= 10;
            output++;
        }
        return output;
    }
}
