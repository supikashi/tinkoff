package edu.hw4;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik), Animal.Sex.M),
            Arguments.of(List.of(bobik, murka), Animal.Sex.F),
            Arguments.of(List.of(murka), Animal.Sex.F),
            Arguments.of(List.of(), Animal.Sex.F)
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 5")
    void TaskTest(Collection<Animal> collection, Animal.Sex expected) {
        // given
        // input

        // when
        Animal.Sex animal = AnimalMethods.task5(collection);

        // then
        assertThat(animal).isEqualTo(expected);
    }
}
