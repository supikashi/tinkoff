package edu.hw3;

import edu.hw3.Task7.TreeMapComparator;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Тест компаратора")
    void ComparatorTest() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(new TreeMapComparator());

        // when
        tree.put(null, "test");

        // then
        assertThat(tree.containsKey(null)).isTrue();
    }

}
