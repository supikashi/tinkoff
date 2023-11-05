package edu.project1;

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

    public void run() {
        while (!(session.thisIsDefeat() || session.thisIsVictory())) {
            LOGGER.info("The word: " + session.getCurrentWord());
            if (session.guess(consoleReader.getLetter())) {
                LOGGER.info("Hit!");
            } else {
                LOGGER.info("Missed, mistake " + session.getUsedAttempts()
                    + " out of " + session.getMaxAttempts());
            }
        }
        if (session.thisIsVictory()) {
            LOGGER.info("Full word: " + session.getWord());
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }
}
