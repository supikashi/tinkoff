package edu.project1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleReader {
    private static Scanner in;
    private final static Logger LOGGER = LogManager.getLogger();

    public ConsoleReader() {
        in = new Scanner(System.in);
    }

    public ConsoleReader(String input) {
        in = new Scanner(input);
    }

    public char getLetter() {
        String input = null;
        do {
            if (input != null) {
                LOGGER.info("Enter only one lowercase letter");
            }
            LOGGER.info("Guess a letter: ");
            try {
                input = in.next();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        } while ((input.length() != 1) || (input.charAt(0) < 'a') || ('z' < input.charAt(0)));
        return input.charAt(0);
    }
}
