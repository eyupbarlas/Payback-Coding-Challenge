package com.payback_interview;

import com.payback_interview.challenge.Checkerboard;

public class Main {
    public static void main(String[] args) {
        Checkerboard checkerboard = new Checkerboard();
        for (int round = 1; round <= 100; round++) {
            checkerboard.sendBird();
            checkerboard.calculatePoints();
            checkerboard.redeemCoupons(round);
        }
        checkerboard.findMostValuableCoupon();
    }
}