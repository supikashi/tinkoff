package edu.hw2.Task3;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.ConnectionException;
import edu.hw2.Task3.ConnectionManager.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Connection connection = manager.getConnection();
        for (int i = 0; i < maxAttempts; i++) {
            try {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                if (i + 1 == maxAttempts) {
                    try {
                        connection.close();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    throw new ConnectionException("tryExecute error", e);
                }
            }
        }
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
