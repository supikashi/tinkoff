package edu.hw4;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik), 35, Optional.of(sharik)),
            Arguments.of(List.of(murka, sharik, bobik), 34, Optional.of(murka)),
            Arguments.of(List.of(sharik, bobik), 100, Optional.of(sharik)),
            Arguments.of(List.of(bobik), 41, Optional.of(bobik)),
            Arguments.of(List.of(bobik), 40, Optional.empty()),
            Arguments.of(List.of(), 100, Optional.empty())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 8")
    void TaskTest(Collection<Animal> collection, int k, Optional<Animal> expected) {
        // given
        // input

        // when
        Optional<Animal> animal = AnimalMethods.task8(collection, k);

        // then
        assertThat(animal).isEqualTo(expected);
    }
}
