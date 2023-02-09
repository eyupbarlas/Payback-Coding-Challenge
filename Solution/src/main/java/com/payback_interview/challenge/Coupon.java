package com.payback_interview.challenge;

public class Coupon {
    int row;
    int col;
    int points;

    public Coupon(int row, int col) {
        this.row = row;
        this.col = col;
        this.points = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
