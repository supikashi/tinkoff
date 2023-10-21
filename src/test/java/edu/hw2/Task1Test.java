package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"0, 0", "1234.4321, 1234.4321", "-6234.9, -6234.9"})
    @DisplayName("Константы")
    void ExprConstantTest(double input, double expected) {
        // given
        // input

        // when
        double x = (new Expr.Constant(input)).evaluate();

        // then
        assertThat(x).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1234.4321, -1234.4321", "-6234.9, 6234.9"})
    @DisplayName("Противоположные числа")
    void ExprNegateTest(double input, double expected) {
        // given
        // input

        // when
        double x = (new Expr.Negate(input)).evaluate();

        // then
        assertThat(x).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 1", "3, 4, 81", "-2, 3, -8"})
    @DisplayName("Возведение в степень")
    void ExprExponentTest(double inputBase, double inputExponent, double expected) {
        // given
        // input

        // when
        double x = (new Expr.Exponent(inputBase, inputExponent)).evaluate();

        // then
        assertThat(x).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "-1, 1, 0", "-345, 456, 111"})
    @DisplayName("Сложение")
    void ExprAdditionTest(double inputA, double inputB, double expected) {
        // given
        // input

        // when
        double x = (new Expr.Addition(inputA, inputB)).evaluate();

        // then
        assertThat(x).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "-12345, 0, 0", "-12, -3, 36"})
    @DisplayName("Умножение")
    void ExprMultiplicationTest(double inputA, double inputB, double expected) {
        // given
        // input

        // when
        double x = (new Expr.Multiplication(inputA, inputB)).evaluate();

        // then
        assertThat(x).isEqualTo(expected);
    }

    @Test
    @DisplayName("Сложный тест")
    void ExprAdditionTest2() {
        // given
        var inputA = new Expr.Exponent(4, new Expr.Constant(-1));
        var inputB = new Expr.Multiplication(new Expr.Constant(5), new Expr.Negate(-2));

        // when
        double x = (new Expr.Addition(inputA, inputB)).evaluate();

        // then
        assertThat(x).isEqualTo(10.25);
    }
}

