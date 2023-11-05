package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    Animal bobik = new Animal("bobic", Animal.Type.FISH, Animal.Sex.M, 4, 40, 10, true);
    Animal murka = new Animal("murka", Animal.Type.FISH, Animal.Sex.F, 10, 20, 7, false);
    Animal sharik = new Animal("sharik", Animal.Type.DOG, Animal.Sex.M, 3, 34, 12, false);
    Animal fish = new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 1, 20, 20, false);

    @Test
    @DisplayName("Первый тест задания 18")
    void TaskTest1() {
        // given


        // when
        Animal animal = AnimalMethods.task18(List.of(bobik, murka), List.of(sharik, fish));

        // then
        assertThat(animal).isEqualTo(fish);
    }

    @Test
    @DisplayName("Второй тест задания 18")
    void TaskTest2() {
        // given


        // when
        Animal animal = AnimalMethods.task18(List.of(murka), List.of(sharik), List.of(fish), List.of(bobik));

        // then
        assertThat(animal).isEqualTo(fish);
    }

    @Test
    @DisplayName("Третий тест задания 18")
    void TaskTest3() {
        // given


        // when
        Animal animal = AnimalMethods.task18(List.of(sharik, murka));

        // then
        assertThat(animal).isEqualTo(murka);
    }

    @Test
    @DisplayName("Четвёртый тест задания 18")
    void TaskTest4() {
        // given


        // when
        Animal animal = AnimalMethods.task18(List.of(sharik), List.of(sharik, sharik));

        // then
        assertThat(animal).isEqualTo(null);
    }

    @Test
    @DisplayName("Пятый тест задания 18")
    void TaskTest5() {
        // given


        // when
        Animal animal = AnimalMethods.task18(List.of(), List.of());

        // then
        assertThat(animal).isEqualTo(null);
    }
}
