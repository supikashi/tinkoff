package edu.project2;

import edu.project2.Generator.Generator;
import edu.project2.Renderer.ConsoleRenderer;
import edu.project2.Renderer.Renderer;
import edu.project2.Solver.BFSSolver;
import edu.project2.Solver.DFSSolver;
import edu.project2.Solver.Solver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Project2Test {
    Cell[][] c1 = new Cell[][]{{new Cell(true, true, false, true),
        new Cell(true, false, true, true),
        new Cell(true, false, false, false),
        new Cell(true, true, false, false)},
        {new Cell(false, false, true, true),
            new Cell(true, false, false, false),
            new Cell(false, true, true, false),
            new Cell(false, true, false, true)},
        {new Cell(true, false, true, true),
            new Cell(false, false, true, false),
            new Cell(true, false, true, false),
            new Cell(false, true, true, false) }};
    Cell[][] c2 = new Cell[][]{{new Cell(true, true, false, true),
        new Cell(true, false, true, true),
        new Cell(true, false, false, false),
        new Cell(true, true, false, false)},
        {new Cell(false, true, true, true),
            new Cell(true, false, false, true),
            new Cell(false, true, true, false),
            new Cell(false, true, false, true)},
        {new Cell(true, false, true, true),
            new Cell(false, false, true, false),
            new Cell(true, false, true, false),
            new Cell(false, true, true, false) }};
    @Test
    @DisplayName("Тест поиска пути 1")
    void SolverTest1() {
        // given
        Solver solver1 = new DFSSolver();
        Solver solver2 = new BFSSolver();

        // when
        List<Coordinate> list1 = solver1.solve(new Maze(c1), new Coordinate(0, 0), new Coordinate(2, 3));
        List<Coordinate> list2 = solver2.solve(new Maze(c1), new Coordinate(0, 0), new Coordinate(2, 3));

        // then
        assertThat(list1.size()).isEqualTo(8);
        assertThat(list2.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Тест поиска пути 2")
    void SolverTest2() {
        // given
        Solver solver1 = new DFSSolver();
        Solver solver2 = new BFSSolver();

        // when
        List<Coordinate> list1 = solver1.solve(new Maze(c2), new Coordinate(0, 0), new Coordinate(2, 3));
        List<Coordinate> list2 = solver2.solve(new Maze(c2), new Coordinate(0, 0), new Coordinate(2, 3));

        // then
        assertThat(list1.isEmpty()).isEqualTo(true);
        assertThat(list2.isEmpty()).isEqualTo(true);
    }

    static Arguments[] renderSource() {
        return new Arguments[] {
            Arguments.of(new Maze(Generator.generateMazeWithAllWalls(2, 3)), "\n██████████████\n" +
                                                                                                              "██  ██  ██  ██\n" +
                                                                                                              "██████████████\n" +
                                                                                                              "██  ██  ██  ██\n" +
                                                                                                              "██████████████")
        };
    }

    @ParameterizedTest
    @MethodSource("renderSource")
    @DisplayName("Тест вывода")
    void ConsoleRendererTest(Maze maze, String expected) {
        // given
        Renderer r = new ConsoleRenderer();

        // when
        String str = r.render(maze);

        // then
        assertThat(expected).isEqualTo(str);

    }

    @Test
    @DisplayName("Тест создания лабиринта")
    void MazeTest1() {
        Cell[][] cells = new Cell[2][];
        cells[0] = new Cell[]{new Cell(), new Cell()};
        cells[1] = new Cell[]{new Cell(), new Cell(), new Cell()};

        assertThrows(IllegalArgumentException.class, () -> {
            new Maze(cells);
        });

    }

    @Test
    @DisplayName("Тест исключения при поиске пути")
    void SolveExceptionTest() {
        Solver s = new BFSSolver();

        assertThrows(IllegalArgumentException.class, () ->
            s.solve(new Maze(c1), new Coordinate(-1, 0), new Coordinate(1, 1)));

    }
}
