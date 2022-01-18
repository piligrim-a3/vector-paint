package ru.bgpu.mvntest;

import java.awt.*;

public interface Figure {

    void paint(Graphics graphics);
    void move(int dx,int dy);
    boolean contains(int x, int y);
}
