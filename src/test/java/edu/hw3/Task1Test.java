package edu.hw3;

import edu.hw3.Task1.Atbash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"Hello world!, Svool dliow!",
        "abcABCzyxZYX, zyxZYXabcABC",
        "123абвАБВ, 123абвАБВ",
        "!@#$%^&*(), !@#$%^&*()"})
    @DisplayName("Шифр Атбаша")
    void atbashTest(String input, String expected) {
        // given
        // input

        // when
        String str = Atbash.encryptViaAtbash(input);

        // then
        assertThat(str).isEqualTo(expected);
    }
}
