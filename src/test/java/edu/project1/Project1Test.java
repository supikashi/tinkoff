package edu.project1;

import edu.project.ConsoleHangman;
import edu.project.ConsoleReader;
import edu.project.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({"j v a, 3, 1, 1, java",
                "j v a, 2, 0, 1, j*v*",
                "q w e r j t, 6, -1, 6, j***",
                "j v q a, 4, 1, 2, java"})
    @DisplayName("Тест сессии")
    void ConsoleReaderTest(String input, int steps, int result, int attempt, String word) {
        // given
        Session session = new Session("java", 5);
        ConsoleHangman consoleHangman = new ConsoleHangman(session, input);

        // when
        int res = consoleHangman.testRun(steps);

        // then
        assertThat(res).isEqualTo(result);
        assertThat(session.getCurrentAttempt()).isEqualTo(attempt);
        assertThat(session.getCurrentWord()).isEqualTo(word);
    }
}
