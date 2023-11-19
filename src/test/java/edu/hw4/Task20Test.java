package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    static Arguments[] source() {
        Animal bobik = new Animal("", Animal.Type.DOG, Animal.Sex.M, -1, 40, 10, true);
        Animal murka = new Animal("murka", null, Animal.Sex.F, -10, -5, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, null, 3, 30, -60, false);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, true);
        return new Arguments[] {
            Arguments.of(List.of(murka, bobik, sharik, pauk),
                Map.of("", "name, age",
                "murka", "type, age, height",
                "sharik", "sex, weight",
                "pauk", "")),
            Arguments.of(List.of(), Map.of())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 20")
    void TaskTest(Collection<Animal> collection, Map<String, String> expected) {
        // given
        // input

        // when
        Map<String, String> map = AnimalMethods.task20(collection);

        // then
        assertThat(map).isEqualTo(expected);
    }
}
