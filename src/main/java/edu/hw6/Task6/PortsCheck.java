package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortsCheck {
    private PortsCheck() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    private static final int NUMBER_OF_PORTS = 49152;
    private static final String TCP = "TCP ";
    private static final String UDP = "UDP ";

    public static boolean[] check() {
        boolean[] isPortFree = new boolean[NUMBER_OF_PORTS];
        for (int i = 1; i < NUMBER_OF_PORTS; i++) {
            try (ServerSocket serverSocket = new ServerSocket(i)) {
                if (serverSocket.getLocalPort() == i) {
                    isPortFree[i] = true;
                } else {
                    isPortFree[i] = false;
                    LOGGER.info(TCP + i);
                }
            } catch (IOException e) {
                isPortFree[i] = false;
                LOGGER.info(TCP + i);
            }
            try (DatagramSocket datagramSocket = new DatagramSocket(i)) {
                if (datagramSocket.getLocalPort() == i) {
                    isPortFree[i] = true;
                } else {
                    isPortFree[i] = false;
                    LOGGER.info(UDP + i);
                }
            } catch (IOException e) {
                isPortFree[i] = false;
                LOGGER.info(UDP + i);
            }
        }
        return isPortFree;
    }
}
