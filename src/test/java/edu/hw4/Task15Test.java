package edu.hw4;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, false);
        Animal.Type cat = Animal.Type.CAT;
        Animal.Type dog = Animal.Type.DOG;
        Animal.Type bird = Animal.Type.BIRD;
        Animal.Type fish = Animal.Type.FISH;
        Animal.Type spider = Animal.Type.SPIDER;
        return new Arguments[] {
            Arguments.of(List.of(bobik, murka, sharik, pauk), 1, 11, Map.of(cat, 7, dog, 22, bird, 0, fish, 0, spider, 1)),
            Arguments.of(List.of(bobik, murka, sharik), 3, 4, Map.of(cat, 0, dog, 12, bird, 0, fish, 0, spider, 0)),
            Arguments.of(List.of(pauk), 1, 2, Map.of(cat, 0, dog, 0, bird, 0, fish, 0, spider, 1)),
            Arguments.of(List.of(), 1, 2, Map.of(cat, 0, dog, 0, bird, 0, fish, 0, spider, 0))
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 15")
    void TaskTest(Collection<Animal> input, int k, int l, Map<Animal.Type, Integer> expected) {
        // given
        // input

        // when
        Map<Animal.Type, Integer> map = AnimalMethods.task15(input, k, l);

        // then
        assertThat(map).isEqualTo(expected);
    }
}
