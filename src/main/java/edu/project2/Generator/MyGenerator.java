package edu.project2.Generator;

import edu.project2.Cell;
import edu.project2.Coordinate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// это вроде recursive backtracker, но только когда из текущей ячейки некуда идти,
// выбирается не верхняя из стека, а случайная
// и также после генерации идеального лабиринта удаляется несколько рандомных стен,
// то что некоторые удаленные стены и так не существовали - не баг а фича
public class MyGenerator implements Generator {
    private static final int N = 4;

    public Cell[][] generate(int height, int width, int countOfDeletedWalls) {
        Cell[][] maze = Generator.generateMazeWithAllWalls(height, width);
        boolean[][] used = new boolean[height][width];
        Coordinate current = new Coordinate(0, 0);
        Set<Coordinate> available = new HashSet<>();
        available.add(current);
        Random rnd = new Random();
        Coordinate[] mask = {new Coordinate(-1, 0),
             new Coordinate(0, 1),
             new Coordinate(1, 0),
             new Coordinate(0, -1)};

        while (!available.isEmpty()) {
            used[current.y()][current.x()] = true;
            List<Coordinate> availCoords = new ArrayList<>();
            List<Integer> availDirs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Coordinate tmp = new Coordinate(current.y() + mask[i].y(), current.x() + mask[i].x());
                if (0 <= tmp.y() && tmp.y() < height
                    && 0 <= tmp.x() && tmp.x() < width
                    && !used[tmp.y()][tmp.x()]) {

                    availCoords.add(new Coordinate(current.y() + mask[i].y(), current.x() + mask[i].x()));
                    availDirs.add(i);
                }
            }

            if (availCoords.isEmpty()) {
                available.remove(current);
                if (!available.isEmpty()) {
                    current = available.stream().toList().get(rnd.nextInt(available.size()));
                }
            } else {
                if (availCoords.size() == 1) {
                    available.remove(current);
                }
                int choice = rnd.nextInt(availCoords.size());
                maze[current.y()][current.x()].setOneWall(availDirs.get(choice), false);
                current = availCoords.get(choice);
                maze[current.y()][current.x()].setOneWall((availDirs.get(choice) + 2) % N, false);
                available.add(current);
            }
        }

        for (int i = 0; i < countOfDeletedWalls; i++) {
            int y = rnd.nextInt(height);
            int x = rnd.nextInt(width);
            int wall = rnd.nextInt(N);
            Coordinate tmp = new Coordinate(y + mask[wall].y(), x + mask[wall].x());
            if (0 <= tmp.y() && tmp.y() < height
                && 0 <= tmp.x() && tmp.x() < width) {

                maze[y][x].setOneWall(wall, false);
                maze[tmp.y()][tmp.x()].setOneWall((wall + 2) % N, false);
            }
        }
        return maze;
    }
}
