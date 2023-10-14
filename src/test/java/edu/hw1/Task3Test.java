package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "7, 1",
        "1000, 4", "99, 2", "123456, 6"})
    @DisplayName("Task2Tests")
    void countDigitsTest(int input, int expected) {
        // given
        // input

        // when
        int x = Task3.countDigits(input);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
