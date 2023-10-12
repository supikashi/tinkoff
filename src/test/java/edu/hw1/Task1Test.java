package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("минуты секунды")
    void checkminutes() {
        // given
        String s = "11:05";

        // when
        int x = Task1.minutesToSeconds(s);

        // then
        assertThat(x)
            .isEqualTo(665);
    }
}
