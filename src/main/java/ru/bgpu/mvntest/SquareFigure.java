package ru.bgpu.mvntest;

import java.awt.*;

public class SquareFigure implements Figure{

    private Color color = Color.BLUE;
    private int x = 0,y = 0;
    private int width = 100;
    private int height = 100;

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x,y,width,height);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean contains(int x, int y) {
        return x > this.x && x < this.x+width &&
                y > this.y && y < this.y+height;
    }
}
