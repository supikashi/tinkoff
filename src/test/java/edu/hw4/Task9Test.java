package edu.hw4;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, false);
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik, pauk), 20),
            Arguments.of(List.of(murka, sharik, bobik), 12),
            Arguments.of(List.of(sharik, bobik), 8),
            Arguments.of(List.of(pauk), 8),
            Arguments.of(List.of(), 0)
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 9")
    void TaskTest(Collection<Animal> collection, Integer expected) {
        // given
        // input

        // when
        Integer x = AnimalMethods.task9(collection);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
