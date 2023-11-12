package edu.hw5;

import edu.hw5.Task6.MySubstring;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    static Arguments[] source() {
        return new Arguments[] {
            Arguments.of("abc", "achfdbaabgabcaabg", true),
            Arguments.of("abc", "achfdbaabgbcaabg", true),
            Arguments.of("abc", "chfdbbgbcaabg", false),
            Arguments.of("2", "9709873952", true),
            Arguments.of("2", "970987395", false),
            Arguments.of("$", "$", true),
            Arguments.of("", "9709873952", true),
        };
    }

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Тест задания 6")
    void Task5Test(String s, String t, boolean expected) {
        // given
        // String s, t

        // when
        boolean x = MySubstring.isSubstring(s, t);

        // then
        assertThat(x).isEqualTo(expected);
    }
}
