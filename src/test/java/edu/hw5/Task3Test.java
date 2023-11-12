package edu.hw5;

import edu.hw5.Task3.MyDateParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] source() {
        return new Arguments[] {
            Arguments.of("2022-12-1", Optional.of(LocalDate.of(2022, 12, 1))),
            Arguments.of("2022-31-12", Optional.of(LocalDate.of(2022, 12, 31))),
            Arguments.of("1/1/12", Optional.of(LocalDate.of(2012, 1, 1))),
            Arguments.of("1/1/2012", Optional.of(LocalDate.of(2012, 1, 1))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("12 day ago", Optional.of(LocalDate.now().minusDays(12))),
            Arguments.of("-1 day ago", Optional.empty()),
            Arguments.of(" 1 day ago", Optional.empty()),
            Arguments.of("1day ago", Optional.empty()),
            Arguments.of("1 dy ago", Optional.empty()),
            Arguments.of("-1 day ago", Optional.empty()),
            Arguments.of("2022-12-32", Optional.empty()),
            Arguments.of("", Optional.empty())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 3")
    void Task3Tests(String input, Optional<LocalDate> expected) {
        // given
        // input

        // when
        Optional<LocalDate> date = MyDateParser.parseDate(input);

        // then
        assertThat(date).isEqualTo(expected);
    }
}
