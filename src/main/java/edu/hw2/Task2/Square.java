package edu.hw2.Task2;

public class Square extends Rectangle {
    public Square(int x) {
        super(x, x);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.getHeight());
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(this.getWidth(), height);
    }
}
