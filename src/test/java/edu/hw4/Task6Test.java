package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
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
            Arguments.of(List.of(bobik, murka, sharik, pauk), Map.of(cat, murka, dog, sharik, bird, null, fish, null, spider, pauk)),
            Arguments.of(List.of(murka, sharik, bobik), Map.of(cat, murka, dog, sharik, bird, null, fish, null, spider, null)),
            Arguments.of(List.of(pauk), Map.of(cat, null, dog, null, bird, null, fish, null, spider, pauk)),
            Arguments.of(List.of(), Map.of(cat, null, dog, null, bird, null, fish, null, spider, null))
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 6")
    void TaskTest(Collection<Animal> input, Map<Animal.Type, Animal> expected) {
        // given
        // input

        // when
        Map<Animal.Type, Animal> map = AnimalMethods.task6(input);

        // then
        assertThat(map).isEqualTo(expected);
    }
}
