package edu.hw1;

public class Task2 {

    private Task2() {
    }

    @SuppressWarnings("MagicNumber") //мне кажется странным заводить константу для 10
    public static int countDigits(int input) {
        int output = 1;
        int powerOfTen = 10;
        int num = input;
        if (num < 0) { //не знаю надо ли было это проверять
            num *= -1;
        }
        while (powerOfTen <= num) {
            powerOfTen *= 10;
            output++;
        }
        return output;
    }
}
