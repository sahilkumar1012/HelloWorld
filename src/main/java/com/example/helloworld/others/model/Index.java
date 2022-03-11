package com.example.helloworld.others.model;

import java.util.Objects;

/**
 * Index class to store x,y point in a grid.
 */
public class Index {
    public int x;
    public int y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return x == index.x && y == index.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Index{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
