package edu.project2.Renderer;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ConsoleRenderer implements Renderer {
    public String render(@NotNull Maze maze) {
        return render(maze, new ArrayList<>());
    }

    @SuppressWarnings("MultipleStringLiterals")
    public String render(Maze maze, List<Coordinate> path) {
        boolean[][] pathCells = new boolean[maze.getHeight()][maze.getWidth()];
        path.forEach(c -> pathCells[c.y()][c.x()] = true);
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                sb.append(maze.grid[i][j].getTopWall() ? "████" : "██  ");
            }
            sb.append("██\n");
            for (int j = 0; j < maze.getWidth(); j++) {
                if (pathCells[i][j]) {
                    sb.append(maze.grid[i][j].getLeftWall() ? "██◁▷" : "  ◁▷");
                } else {
                    sb.append(maze.grid[i][j].getLeftWall() ? "██  " : "    ");
                }
            }
            sb.append("██\n");
        }
        sb.append("██".repeat(maze.getWidth() * 2 + 1));
        return new String(sb);
    }
}
