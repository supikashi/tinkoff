package edu.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final Session session;
    private final ConsoleReader consoleReader;
    private final static Logger LOGGER = LogManager.getLogger();

    public ConsoleHangman(Session session) {
        this.session = session;
        consoleReader = new ConsoleReader();
    }

    public ConsoleHangman(Session session, String input) {
        this.session = session;
        consoleReader = new ConsoleReader(input);
    }

    public void run() {
        while (session.getCurrentAttempt() <= session.getMaxAttempts()
            && !session.getCurrentWord().equals(session.getWord())) {
            step();
        }
        if (session.getCurrentAttempt() <= session.getMaxAttempts()) {
            LOGGER.info("Full word: " + session.getCurrentWord());
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }

    public int testRun(int steps) {
        for (int i = 0; i < steps; i++) {
            step();
            if (session.getCurrentAttempt() > session.getMaxAttempts()) {
                return -1; // поражение
            }
            if (session.getCurrentWord().equals(session.getWord())) {
                return 1; // победа
            }
        }
        return 0; // игра не закончена
    }

    private void step() {
        LOGGER.info("The word: " + session.getCurrentWord());
        char input = consoleReader.getLetter();
        if (session.getWord().indexOf(input) != -1) {
            LOGGER.info("Hit!");
            session.successfulGuess(input);
        } else {
            LOGGER.info("Missed, mistake " + session.getCurrentAttempt()
                + " out of " + session.getMaxAttempts());
            session.nextAttempt();
        }
    }
}
