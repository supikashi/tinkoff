package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.regex.Matcher;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegularsTest {
    static Arguments[] source4() {
        return new Arguments[] {
            Arguments.of("qwerty12345", false),
            Arguments.of("qwerty12345~", true),
            Arguments.of("!qwerty", true),
            Arguments.of("qwer@ty", true),
            Arguments.of("q#werty", true),
            Arguments.of("qw$erty", true),
            Arguments.of("qwer^ty", true),
            Arguments.of("qwert&y", true),
            Arguments.of("qwert*y", true),
            Arguments.of("qwe|rty", true),
            Arguments.of("~!@#$%^&*|", true),
            Arguments.of("!", true),
            Arguments.of("", false),
        };
    }

    @ParameterizedTest
    @MethodSource("source4")
    @DisplayName("Тест задания 4")
    void Task4Test(String input, boolean expected) {
        // given
        Matcher matcher = Regulars.strongPasswordPattern.matcher(input);

        // when
        boolean match = matcher.find();

        // then
        assertThat(match).isEqualTo(expected);
    }

    static Arguments[] source5() {
        return new Arguments[] {
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО777", true),
            Arguments.of("Е777АТ54", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВГ77", false),
            Arguments.of("А123ВЕ7777", false),
            Arguments.of("", false)
        };
    }

    @ParameterizedTest
    @MethodSource("source5")
    @DisplayName("Тест задания 5")
    void Task5Test(String input, boolean expected) {
        // given
        Matcher matcher = Regulars.vehicleRegistrationPlates.matcher(input);

        // when
        boolean match = matcher.find();

        // then
        assertThat(match).isEqualTo(expected);
    }

    static Arguments[] source7() {
        return new Arguments[] {
            Arguments.of("1010011010110", false, false, false),
            Arguments.of("1010011010111", false, true, false),
            Arguments.of("1000011010110", true, false, false),

            Arguments.of("10", false, false, true),
            Arguments.of("01", false, false, true),
            Arguments.of("11", false, true, true),
            Arguments.of("0", false, true, true),
            Arguments.of("010", true, true, true),
            Arguments.of("2010", false, false, false),
            Arguments.of("01a0", false, false, false),
            Arguments.of("010 ", false, false, false),
            Arguments.of("", false, false, false)
        };
    }

    @ParameterizedTest
    @MethodSource("source7")
    @DisplayName("Тест задания 7")
    void Task7Test(String input, boolean expected1, boolean expected2, boolean expected3) {
        // given
        Matcher matcher1 = Regulars.binaryString1.matcher(input);
        Matcher matcher2 = Regulars.binaryString2.matcher(input);
        Matcher matcher3 = Regulars.binaryString3.matcher(input);

        // when
        boolean match1 = matcher1.find();
        boolean match2 = matcher2.find();
        boolean match3 = matcher3.find();

        // then
        assertThat(match1).isEqualTo(expected1);
        assertThat(match2).isEqualTo(expected2);
        assertThat(match3).isEqualTo(expected3);
    }
}
