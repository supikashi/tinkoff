package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @ParameterizedTest
    @CsvSource({"3524, 3",
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "1000, -1",
        "6174, 0"})
    @DisplayName("Task6Tests")
    void countKTest(int input, int expected) {
        // given
        // input

        // when
        int x = Task6.countK(input);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
