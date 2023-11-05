package edu.project2;

import edu.project2.Generator.Generator;
import edu.project2.Generator.MyGenerator;
import edu.project2.Renderer.ConsoleRenderer;
import edu.project2.Renderer.Renderer;
import edu.project2.Solver.BFSSolver;
import edu.project2.Solver.DFSSolver;
import edu.project2.Solver.Solver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        Generator g = new MyGenerator();
        Cell[][] c = g.generate(3, 4, 5);
        Renderer r = new ConsoleRenderer();
        Solver bfs = new BFSSolver();
        Solver dfs = new DFSSolver();
        Maze m = new Maze(c);
        LOGGER.info(r.render(
            new Maze(c),
            dfs.solve(m, new Coordinate(0, 0), new Coordinate(m.getHeight() - 1, m.getWidth() - 1))
        ));
        LOGGER.info(r.render(
            new Maze(c),
            bfs.solve(m, new Coordinate(0, 0), new Coordinate(m.getHeight() - 1, m.getWidth() - 1))
        ));
    }
}
