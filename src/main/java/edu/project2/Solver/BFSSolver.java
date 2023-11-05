package edu.project2.Solver;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSSolver implements Solver {
    private static final Coordinate[] MASK = {new Coordinate(-1, 0),
         new Coordinate(0, 1),
         new Coordinate(1, 0),
         new Coordinate(0, -1)};
    private static final int N = 4;

    @SuppressWarnings("CyclomaticComplexity")
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        inputCheck(maze, start, end);
        int[][] used = new int[maze.getHeight()][maze.getWidth()];
        List<Coordinate> path = new ArrayList<>();
        Cell[][] cells = maze.grid;
        Queue<Coordinate> q = new ArrayDeque<>();

        q.offer(start);
        used[q.peek().y()][q.peek().x()] = 1;
        while (!q.isEmpty() && !q.peek().equals(end)) {
            for (int i = 0; i < N; i++) {
                Coordinate tmp = new Coordinate(q.peek().y() + MASK[i].y(), q.peek().x() + MASK[i].x());
                if (!cells[q.peek().y()][q.peek().x()].getWalls()[i]
                    && used[tmp.y()][tmp.x()] == 0) {

                    used[tmp.y()][tmp.x()] = used[q.peek().y()][q.peek().x()] + 1;
                    q.offer(tmp);
                }
            }
            q.remove();
        }
        if (q.peek() == null) {
            return path;
        }
        Coordinate cur = q.peek();
        path.add(cur);
        while (used[cur.y()][cur.x()] != 1) {
            for (int i = 0; i < N; i++) {
                Coordinate tmp = new Coordinate(cur.y() + MASK[i].y(), cur.x() + MASK[i].x());
                if (!cells[cur.y()][cur.x()].getWalls()[i]
                    && used[tmp.y()][tmp.x()] == used[cur.y()][cur.x()] - 1) {

                    cur = tmp;
                    break;
                }
            }
            path.add(cur);
        }
        return path;
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
