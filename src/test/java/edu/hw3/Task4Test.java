package edu.hw3;

import edu.hw3.Task4.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({"2, II",
        "12, XII",
        "16, XVI",
        "100, C",
        "3999, MMMCMXCIX"})
    @DisplayName("Перевод чисел в римские")
    void convertToRomanTest(int input, String expected) {
        // given
        // input

        // when
        String str = Converter.convertToRoman(input);

        // then
        assertThat(str).isEqualTo(expected);
    }
}
