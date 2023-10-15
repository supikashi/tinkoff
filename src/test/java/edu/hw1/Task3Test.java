package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test1")
    void isNestableTest1() {
        // given
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {0, 6};

        // when
        boolean x = Task3.isNestable(firstArray, secondArray);

        // then
        assertThat(x).isEqualTo(true);
    }

    @Test
    @DisplayName("Test2")
    void isNestableTest2() {
        // given
        int[] firstArray = {3, 1};
        int[] secondArray = {4, 0};

        // when
        boolean x = Task3.isNestable(firstArray, secondArray);

        // then
        assertThat(x).isEqualTo(true);
    }

    @Test
    @DisplayName("Test3")
    void isNestableTest3() {
        // given
        int[] firstArray = {9, 9, 8};
        int[] secondArray = {8, 9};

        // when
        boolean x = Task3.isNestable(firstArray, secondArray);

        // then
        assertThat(x).isEqualTo(false);
    }

    @Test
    @DisplayName("Test4")
    void isNestableTest4() {
        // given
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {2, 3};

        // when
        boolean x = Task3.isNestable(firstArray, secondArray);

        // then
        assertThat(x).isEqualTo(false);
    }

    @Test
    @DisplayName("Test5")
    void isNestableTest5() {
        // given
        int[] firstArray = {1};
        int[] secondArray = {1};

        // when
        boolean x = Task3.isNestable(firstArray, secondArray);

        // then
        assertThat(x).isEqualTo(false);
    }
}
