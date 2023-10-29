package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;

public class Task2Test {
    static Rectangle rectangle = new Rectangle(40, 50);
    static Square square = new Square(20);

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(10, 20), 200),
            Arguments.of(new Square(30), 900),
            Arguments.of(rectangle.setWidth(20), 1000),
            Arguments.of(square.setHeight(30), 600)
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    @DisplayName("Тест квадратов и прямоугольников")
    void rectangleArea(Rectangle rect, int expected) {
        //given
        //rect

        //when
        int x = rect.area();

        //then
        assertThat(x).isEqualTo(expected);
    }
}
