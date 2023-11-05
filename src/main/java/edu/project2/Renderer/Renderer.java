package edu.project2.Renderer;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface Renderer {
    String render(@NotNull Maze maze);

    String render(Maze maze, List<Coordinate> path);
}
