package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    @ParameterizedTest
    @CsvSource({"q, q", "q a, q", "A   asd 2 df3AS3 t, t"})
    @DisplayName("Тест считывания буквы")
    void ConsoleReaderTest(String input, char expected) {
        // given
        ConsoleReader consoleReader = new ConsoleReader(input);

        // when
        char x = consoleReader.getLetter();

        // then
        assertThat(x).isEqualTo(expected);
    }

    static Arguments[] complexSource() {
        return new Arguments[] {
            Arguments.of("jva", true, false, 0, "java"),
            Arguments.of("jrtv", false, false, 2, "j*v*"),
            Arguments.of("qwerjt", false, true, 5, "j***"),
            Arguments.of("jvqa", true, false, 1, "java")
        };
    }

    @ParameterizedTest
    @MethodSource("complexSource")
    @DisplayName("Комплексный тест сессии")
    void sessionComplexTest(String input, boolean victory, boolean defeat, int attempt, String word) {
        // given
        Session session = new Session("java", 5);
        char[] in = input.toCharArray();

        // when
        for (char ch : in) {
            session.guess(ch);
        }

        // then
        assertThat(session.thisIsVictory()).isEqualTo(victory);
        assertThat(session.thisIsDefeat()).isEqualTo(defeat);
        assertThat(session.getUsedAttempts()).isEqualTo(attempt);
        assertThat(session.getCurrentWord()).isEqualTo(word);
    }

    @ParameterizedTest
    @CsvSource({"j, true", "a, true", "q, false", "e, false"})
    @DisplayName("Тест сессии")
    void sessionTest(char input, boolean expected) {
        // given
        // input
        Session session = new Session("java", 5);

        // when
        boolean x = session.guess(input);

        // then
        assertThat(x).isEqualTo(expected);
    }

    static Arguments[] extremeSource() {
        return new Arguments[] {
            Arguments.of("", 3, true, false),
            Arguments.of("", 0, true, true),
            Arguments.of("abc", -3, false, true)
        };
    }

    @ParameterizedTest
    @MethodSource("extremeSource")
    @DisplayName("Тест сессии (крайние случаи)")
    void extremeSessionTest(String word, int maxAttempts, boolean victoryExp, boolean defeatExp) {
        // given
        Session session = new Session(word, maxAttempts);

        // when
        boolean victory = session.thisIsVictory();
        boolean defeat = session.thisIsDefeat();

        // then
        assertThat(victory).isEqualTo(victoryExp);
        assertThat(defeat).isEqualTo(defeatExp);
    }
}
