package edu.hw3;

import edu.hw3.Task2.Cluster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] cluster() {
        return new Arguments[] {
            Arguments.of("()()()", new String[] {"()", "()", "()"}),
            Arguments.of("((()))", new String[] {"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"}),
            Arguments.of(")(", new String[0])
        };
    }

    @ParameterizedTest
    @MethodSource("cluster")
    @DisplayName("Кластеризация скобок")
    void clusterizeTest(String input, String[] expected) {
        // given
        // input

        // when
        String[] str = Cluster.clusterize(input);

        // then
        assertThat(str).isEqualTo(expected);
    }
}
