package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Тест компаратора 1")
    void ComparatorTest1() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder())); //(new TreeMapComparator());

        // when
        tree.put(null, "test");

        // then
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("Тест компаратора 2")
    void ComparatorTest2() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder())); //(new TreeMapComparator());

        // when
        tree.put("qwerty", "abc");
        tree.put(null, "test");
        tree.put("java", "int");

        // then
        assertThat(tree.firstKey()).isEqualTo(null);
    }
}
