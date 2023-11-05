package edu.project2;

import org.jetbrains.annotations.NotNull;

public class Cell {
    private static final int N = 4;
    private boolean[] walls;

    public Cell() {
        this.walls = new boolean[] {true, true, true, true};
    }

    public Cell(boolean top, boolean right, boolean bottom, boolean left) {
        this.walls = new boolean[] {top, right, bottom, left};
    }

    public Cell(boolean @NotNull [] walls) {
        if (walls.length != N) {
            throw new IllegalArgumentException();
        }
        this.walls = walls.clone();
    }

    public boolean getTopWall() {
        return walls[0];
    }

    public boolean getRightWall() {
        return walls[1];
    }

    public boolean getBottomWall() {
        return walls[2];
    }

    @SuppressWarnings("MagicNumber")
    public boolean getLeftWall() {
        return walls[3];
    }

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(boolean @NotNull [] walls) {
        if (walls.length != N) {
            throw new IllegalArgumentException();
        }
        this.walls = walls.clone();
    }

    public void setOneWall(int k, boolean wall) {
        if (k < 0 || N <= k) {
            throw new IllegalArgumentException();
        }
        this.walls[k] = wall;
    }
}
