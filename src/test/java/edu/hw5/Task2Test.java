package edu.hw5;

import edu.hw5.Task2.FridayThirteenthFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] source1() {
        return new Arguments[] {
            Arguments.of(2024, List.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13))),
            Arguments.of(1925, List.of(LocalDate.of(1925, 2, 13), LocalDate.of(1925, 3, 13), LocalDate.of(1925, 11, 13)))
        };
    }

    @ParameterizedTest
    @MethodSource("source1")
    @DisplayName("Тест поиска всех пятниц 13-е в году")
    void Task2Test1(int input, Collection<LocalDate> expected) {
        // given
        // input

        // when
        Collection<LocalDate> fridays = FridayThirteenthFinder.getAllInYear(input);

        // then
        assertThat(fridays).isEqualTo(expected);
    }

    static Arguments[] source2() {
        return new Arguments[] {
            Arguments.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13)),
            Arguments.of(LocalDate.of(1925, 11, 13), LocalDate.of(1926, 8, 13))
        };
    }

    @ParameterizedTest
    @MethodSource("source2")
    @DisplayName("Тест поиска следующей пятницы 13-е")
    void Task2Test2(LocalDate input, LocalDate expected) {
        // given
        // input

        // when
        LocalDate friday = FridayThirteenthFinder.getNext(input);

        // then
        assertThat(friday).isEqualTo(expected);
    }
}
