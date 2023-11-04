package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik), List.of(murka, sharik, bobik)),
            Arguments.of(List.of(murka, sharik, bobik), List.of(murka, sharik, bobik)),
            Arguments.of(List.of(bobik, sharik, murka), List.of(murka, sharik, bobik)),
            Arguments.of(List.of(sharik), List.of(sharik)),
            Arguments.of(List.of(), List.of())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 1")
    void TaskTest(Collection<Animal> input, List<Animal> expected) {
        // given
        // input

        // when
        List<Animal> list = AnimalMethods.task1(input);

        // then
        assertThat(list).isEqualTo(expected);
    }
}
