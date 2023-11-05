package edu.hw4;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    static Arguments[] source() {
        Animal bobik = new Animal("bobic", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true);
        Animal murka = new Animal("murka", Animal.Type.CAT, Animal.Sex.F, 10, 20, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 30, 60, false);
        Animal bigdog1 = new Animal("bigdog1", Animal.Type.DOG, Animal.Sex.M, 5, 60, 60, true);
        Animal bigdog2 = new Animal("bigdog2", Animal.Type.DOG, Animal.Sex.F, 6, 53, 54, true);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, true);
        return new Arguments[] {
            Arguments.of(List.of(murka, bobik, sharik, bigdog1, bigdog2, pauk), true),
            Arguments.of(List.of(murka, bobik, bigdog1, bigdog2, pauk), false),
            Arguments.of(List.of(murka, bobik, sharik, bigdog1, bigdog2), false),
            Arguments.of(List.of(), false)
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 17")
    void TaskTest(Collection<Animal> collection, Boolean expected) {
        // given
        // input

        // when
        Boolean x = AnimalMethods.task17(collection);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
