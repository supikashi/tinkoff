package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {
    //private final static Logger LOGGER = LogManager.getLogger();

    private Task5() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int input) { //простите что костыльно

        int countOfDigits = Task2.countDigits(input);
        int[] digitArray = new int[countOfDigits];
        int x = input;
        for (int i = digitArray.length - 1; i >= 0; i--) {
            digitArray[i] = x % 10;
            x /= 10;
        }
        int l;
        int r;
        int k;
        int tmp;
        boolean isPalindrome = false;
        while (countOfDigits != 1) {
            //LOGGER.info(Arrays.toString(digitArray));
            k = 0;
            l = 0;
            r = countOfDigits - 1;
            isPalindrome = true;
            while (l < r) {
                if (digitArray[l] != digitArray[r]) {
                    isPalindrome = false;
                    break;
                }
                l++;
                r--;
            }
            if (isPalindrome) {
                break;
            } else {
                for (int i = 1; i < countOfDigits; i += 2) {
                    tmp = digitArray[i - 1] + digitArray[i];
                    if (tmp > 9) {
                        digitArray[i / 2 + k] = tmp / 10;
                        digitArray[i / 2 + k + 1] = tmp % 10;
                        k++;
                    } else {
                        digitArray[i / 2 + k] = tmp;
                    }
                }
                if (countOfDigits % 2 == 1) {
                    digitArray[countOfDigits / 2 + k] = digitArray[countOfDigits - 1];
                }
                countOfDigits = (countOfDigits + 1) / 2 + k;
            }
        }
        return isPalindrome;
    }
}
