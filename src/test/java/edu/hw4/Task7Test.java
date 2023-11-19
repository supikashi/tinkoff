package edu.hw4;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik), 3, sharik),
            Arguments.of(List.of(murka, sharik, bobik), 1, murka),
            Arguments.of(List.of(sharik, bobik), 2, sharik),
            Arguments.of(List.of(bobik), 1, bobik),
            Arguments.of(List.of(bobik), 2, null),
            Arguments.of(List.of(), 1, null)
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 7")
    void TaskTest(Collection<Animal> collection, int k, Animal expected) {
        // given
        // input

        // when
        Animal animal = AnimalMethods.task7(collection, k);

        // then
        assertThat(animal).isEqualTo(expected);
    }
}
