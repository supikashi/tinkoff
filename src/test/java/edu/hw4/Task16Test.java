package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobik abobik", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 110, 60, false);
        Animal bigdog1 = new Animal("big dog 1", Animal.Type.DOG, Animal.Sex.M, 5, 120, 60, true);
        Animal bigdog2 = new Animal("big dog 2", Animal.Type.DOG, Animal.Sex.F, 6, 101, 54, true);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, true);
        return new Arguments[] {
            Arguments.of(List.of(bobik, sharik, murka, pauk, bigdog1, bigdog2), List.of(murka, bigdog1, bobik, sharik, bigdog2, pauk)),
            Arguments.of(List.of(murka, bobik, sharik, pauk), List.of(murka, bobik, sharik, pauk)),
            Arguments.of(List.of(bigdog1), List.of(bigdog1)),
            Arguments.of(List.of(), List.of())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 16")
    void TaskTest(Collection<Animal> collection, List<Animal> expected) {
        // given
        // input

        // when
        List<Animal> list = AnimalMethods.task16(collection);

        // then
        assertThat(list).isEqualTo(expected);
    }
}
