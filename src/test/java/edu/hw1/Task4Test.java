package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({"123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde",
        "q, q",
        "ok, ko"})
    @DisplayName("Task4Tests")
    void fixStringTest(String input, String expected) {
        // given
        // input

        // when
        String x = Task4.fixString(input);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
