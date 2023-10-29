package edu.hw2.Task3.ConnectionManager;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int CHANCE = 2;
    private int attemptNumber = 1;

    @Override
    public Connection getConnection() {
        return (attemptNumber++ % CHANCE == 0) ? new StableConnection() : new FaultyConnection();
    }
}
