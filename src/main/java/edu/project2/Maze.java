package edu.project2;

public class Maze {
    private final int height;
    private final int width;
    public Cell[][] grid;

    public Maze(Cell[][] grid) {
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
        gridCheck();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void gridCheck() {
        for (int i = 0; i < height; i++) {
            if (grid[i].length != width) {
                throw new IllegalArgumentException();
            }
        }
    }
}
