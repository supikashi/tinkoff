package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"01:00, 60", "13:56, 836", "10:60, -1",
                "10:99, -1", "10:107, -1", "1000:10, 60010"})
    @DisplayName("Task1Tests")
    void minutesToSecondsTest(String input, int expected) {
        // given
        // input

        // when
        int x = Task1.minutesToSeconds(input);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
