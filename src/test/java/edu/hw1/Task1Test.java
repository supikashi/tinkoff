package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("Тест 2")
    void minutesToSecondsTest2() {
        // given
        String s = "13:56";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(836);
    }

    /*@Test
    @DisplayName("Тест 3")
    void minutesToSecondsTest3() {
        // given
        String s = "10:60";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Тест 4")
    void minutesToSecondsTest4() {
        // given
        String s = "10:99";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Тест 5")
    void minutesToSecondsTest5() {
        // given
        String s = "10:107";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Тест 6")
    void minutesToSecondsTest6() {
        // given
        String s = "1000:10";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(60010);
    }*/
}
