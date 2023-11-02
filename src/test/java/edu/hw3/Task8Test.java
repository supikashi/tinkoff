package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Тест листа")
    void listIteratorTest() {
        // given
        Collection<Integer> a = new ArrayList<>(List.of(1, 2, 3));

        // when
        BackwardIterator<Integer> iter = new BackwardIterator<>(a);

        // then
        assertThat(iter.next()).isEqualTo(3);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.hasNext()).isEqualTo(true);
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.hasNext()).isEqualTo(false);
    }

    @Test
    @DisplayName("Тест сета")
    void setIteratorTest() {
        // given
        Collection<Integer> a = new TreeSet<>(List.of(1, 3, 2));

        // when
        BackwardIterator<Integer> iter = new BackwardIterator<>(a);

        // then
        assertThat(iter.next()).isEqualTo(3);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.hasNext()).isEqualTo(true);
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.hasNext()).isEqualTo(false);
    }
}
