package edu.hw3.Task4;

@SuppressWarnings("MagicNumber")
public class Converter {
    private static final int BIGGEST_NUMBER = 3999;

    private Converter() {
    }

    public static String convertToRoman(int num) {
        if (num < 1 || BIGGEST_NUMBER < num) {
            return "";
        }
        int currentNumber = num;
        StringBuilder sb = new StringBuilder();
        while (currentNumber >= 1000) {
            sb.append('M');
            currentNumber -= 1000;
        }
        sb.append(convert(currentNumber / 100, 'M', 'D', 'C'));
        currentNumber %= 100;
        sb.append(convert(currentNumber / 10, 'C', 'L', 'X'));
        currentNumber %= 10;
        sb.append(convert(currentNumber, 'X', 'V', 'I'));
        return sb.toString();
    }

    private static String convert(int num, char ten, char five, char one) {
        int currentNumber = num;
        StringBuilder sb = new StringBuilder();
        if (currentNumber == 9) {
            sb.append(one);
            sb.append(ten);
            currentNumber -= 9;
        }
        if (currentNumber >= 5) {
            sb.append(five);
            currentNumber -= 5;
        }
        if (currentNumber == 4) {
            sb.append(one);
            sb.append(five);
            currentNumber -= 4;
        }
        while (currentNumber > 0) {
            sb.append(one);
            currentNumber--;
        }
        return sb.toString();
    }
}
