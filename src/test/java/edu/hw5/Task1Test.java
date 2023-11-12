package edu.hw5;

import edu.hw5.Task1.DurationAnalysis;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Arguments[] source() {
        return new Arguments[] {
            Arguments.of(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"), Duration.ofMinutes(220)),
            Arguments.of(List.of("2022-03-12, 20:00 - 2022-03-12, 21:00", "2022-04-01, 21:30 - 2022-04-01, 21:31"), Duration.ofMinutes(30)),
            Arguments.of(List.of("2022-04-01, 21:30 - 2022-04-01, 21:31"), Duration.ofMinutes(1)),
            Arguments.of(List.of(), Duration.ofMinutes(-1))
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 1")
    void Task1Tests(Collection<String> input, Duration expected) {
        // given
        // input

        // when
        Duration averageDuration = DurationAnalysis.getAverageDuration(input);

        // then
        assertThat(averageDuration).isEqualTo(expected);
    }
}
