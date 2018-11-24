package com.example.jiaodian.frogger;

public class Pos {
    int x;
    int y;

    public Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos (Pos p) {
        this.x = p.x;
        this.y = p.y;
    }
}
