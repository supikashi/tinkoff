package edu.hw2.Task3.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final int CHANCE = 5;
    private int attemptNumber = 1;

    @Override
    public void execute(String command) {
        if (attemptNumber++ % CHANCE == 0) {
            LOGGER.info("command: \"" + command + "\" executed successfully");
        } else {
            throw new ConnectionException("execute error");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
