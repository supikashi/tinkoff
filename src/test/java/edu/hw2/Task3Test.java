package edu.hw2;

import edu.hw2.Task3.Connection.ConnectionException;
import edu.hw2.Task3.ConnectionManager.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManager.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static final DefaultConnectionManager dcm = new DefaultConnectionManager();

    static Arguments[] source1() {
        return new Arguments[]{
            Arguments.of(new PopularCommandExecutor(new FaultyConnectionManager(), 4)),
            Arguments.of(new PopularCommandExecutor(dcm, 4))
        };
    }

    static Arguments[] source2() {
        return new Arguments[]{
            Arguments.of(new PopularCommandExecutor(new FaultyConnectionManager(), 5)),
            Arguments.of(new PopularCommandExecutor(dcm, 4))
        };
    }

    @ParameterizedTest
    @MethodSource("source1")
    @DisplayName("Тест наличия исключений")
    public void exceptionTest(PopularCommandExecutor pce) {
        Exception exception = assertThrows(ConnectionException.class, () -> {
            pce.updatePackages();
        });

        String expectedMessage = "tryExecute error";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @MethodSource("source2")
    @DisplayName("Teст отсутствия исключений")
    public void notExeptionTest(PopularCommandExecutor pce) {
        assertDoesNotThrow(() -> pce.updatePackages());
    }
}
