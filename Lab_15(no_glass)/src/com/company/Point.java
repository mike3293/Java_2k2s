package com.company;

import java.io.Serializable;

class Point implements Serializable {
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int x;
    public int y;
}
