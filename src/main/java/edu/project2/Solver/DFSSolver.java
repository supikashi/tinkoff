package edu.project2.Solver;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSSolver implements Solver {
    private static final Coordinate[] MASK = {new Coordinate(-1, 0),
        new Coordinate(0, 1),
        new Coordinate(1, 0),
        new Coordinate(0, -1)};
    private static final int N = 4;
    private int[][] used;
    private List<Coordinate> path;
    private Coordinate finish;
    private Cell[][] cells;

    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        inputCheck(maze, start, end);

        used = new int[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            Arrays.fill(used[i], 0);
        }
        path = new ArrayList<>();
        finish = end;
        cells = maze.grid;
        dFS(start);
        return path;
    }

    private boolean dFS(Coordinate cur) {
        used[cur.y()][cur.x()] = 1;
        path.add(cur);
        if (cur.equals(finish)) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            Coordinate tmp = new Coordinate(cur.y() + MASK[i].y(), cur.x() + MASK[i].x());
            if (!cells[cur.y()][cur.x()].getWalls()[i]
                && used[tmp.y()][tmp.x()] == 0) {

                if (dFS(new Coordinate(tmp.y(), tmp.x()))) {
                    return true;
                }
            }
        }
        path.removeLast();
        return false;
    }

    private void inputCheck(Maze maze, Coordinate start, Coordinate end) {
        if (start.y() < 0 || start.y() >= maze.getHeight()
            || start.x() < 0 || start.x() >= maze.getWidth()
            || end.y() < 0 || end.y() >= maze.getHeight()
            || end.x() < 0 || end.x() >= maze.getWidth()) {

            throw new IllegalArgumentException();
        }
    }
}
