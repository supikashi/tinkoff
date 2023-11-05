package edu.project2.Generator;

import edu.project2.Cell;

public interface Generator {
    static Cell[][] generateMazeWithAllWalls(int height, int width) {
        Cell[][] maze = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell();
            }
        }
        return maze;
    }

    Cell[][] generate(int height, int width, int countOfDeletedWalls);
}
