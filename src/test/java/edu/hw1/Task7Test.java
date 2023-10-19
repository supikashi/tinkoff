package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @ParameterizedTest
    @CsvSource({"8, 1, 4",
        "0, 45, 0",
        "1234, 0, 1234",
        "16, 20, 16",
        "4765, 31, 7572"})
    @DisplayName("Task7RotateRightTests")
    void rotateRightTest(int n, int shift, int expected) {
        // given
        // N, Shift

        // when
        int x = Task7.rotateRight(n, shift);

        // then
        assertThat(x).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"16, 1, 1",
        "0, 45, 0",
        "17, 2, 6",
        "16, 20, 16",
        "4765, 31, 5042"})
    @DisplayName("Task7RotateLeftTests")
    void rotateLeftTest(int n, int shift, int expected) {
        // given
        // N, Shift

        // when
        int x = Task7.rotateLeft(n, shift);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
