package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @ParameterizedTest
    @CsvSource({"11211230, true",
        "13001120, true",
        "23336014, true",
        "11, true",
        "9, false",
        "124, false"})
    @DisplayName("Task5Tests")
    void isPalindromeDescendantTest(int input, boolean expected) {
        // given
        // input

        // when
        boolean x = Task5.isPalindromeDescendant(input);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
