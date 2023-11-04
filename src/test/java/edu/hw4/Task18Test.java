package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.FISH, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.FISH, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
        Animal fish = new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 1, 20, 20, false);
        return new Arguments[] {
            Arguments.of(fish, List.of(bobik, murka), List.of(sharik, fish)),
            Arguments.of(fish, List.of(murka), List.of(sharik), List.of(fish), List.of(bobik)),
            Arguments.of(murka, List.of(sharik, murka)),
            Arguments.of(null, List.of(sharik), List.of(sharik, sharik)),
            Arguments.of(null, List.of(), List.of()),
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 18")
    void TaskTest(Animal expected, Collection<Animal>... collections) {
        // given
        Collection<Animal> list1 = (collections.length > 0) ? collections[0] : Collections.emptyList();
        Collection<Animal> list2 = (collections.length > 1) ? collections[1] : Collections.emptyList();
        Collection<Animal> list3 = (collections.length > 2) ? collections[2] : Collections.emptyList();
        Collection<Animal> list4 = (collections.length > 3) ? collections[3] : Collections.emptyList();

        // when
        Animal animal = AnimalMethods.task18(list1, list2, list3, list4);

        // then
        assertThat(animal).isEqualTo(expected);
    }
}
