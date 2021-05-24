package com.example.helloworld.common.model;


public class Index{
    public int x;
    public int y;

    public Index(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Index{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}