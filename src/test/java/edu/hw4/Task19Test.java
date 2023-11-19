package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {
    static Arguments[] source() {
        Animal bobik = new Animal("", Animal.Type.DOG, Animal.Sex.M, -1, 40, 10, true);
        Animal murka = new Animal("murka", null, Animal.Sex.F, -10, -5, 7, false);
        Animal sharik = new Animal("sharik", Animal.Type.DOG, null, 3, 30, -60, false);
        Animal pauk = new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.M, 1, 4, 1, true);
        return new Arguments[] {
            Arguments.of(List.of(murka, bobik, sharik, pauk), Map.of("", Set.of(ValidationError.EMPTY_NAME, ValidationError.NEGATIVE_AGE),
                "murka", Set.of(ValidationError.NULL_TYPE, ValidationError.NEGATIVE_AGE, ValidationError.NEGATIVE_HEIGHT),
                "sharik", Set.of(ValidationError.NULL_SEX, ValidationError.NEGATIVE_WEIGHT),
                "pauk", Set.of())),
            Arguments.of(List.of(), Map.of())
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 19")
    void TaskTest(Collection<Animal> collection, Map<String, Set<ValidationError>> expected) {
        // given
        // input

        // when
        Map<String, Set<ValidationError>> map = AnimalMethods.task19(collection);

        // then
        assertThat(map).isEqualTo(expected);
    }
}
