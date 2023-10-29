package edu.hw2;

import edu.hw1.Task8;
import edu.hw2.Task3.Connection.ConnectionException;
import edu.hw2.Task3.ConnectionManager.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManager.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    @DisplayName("Тест callingInfo")
    public void callingInfoTest() {
        // given
        // this class and method

        // when
        CallingInfo callingInfo = CallingInfo.callingInfo();

        // then
        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(callingInfo.methodName()).isEqualTo("callingInfoTest");
    }
}
