package com.payback_interview.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Checkerboard {
    public int rows = 15;
    public int cols = 15;
    public ArrayList<Coupon> coupons = new ArrayList<>();
    public ArrayList<Pointee> pointees = new ArrayList<>();
    Random rand = new Random();

    public Checkerboard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                coupons.add(new Coupon(i, j));
                pointees.add(new Pointee(i, j));
            }
        }
    }

    public void sendBird() {
        for (Pointee pointee : pointees) {
            int direction = rand.nextInt(4);
            switch (direction) {
                case 0 -> {
                    if (pointee.row > 0) {
                        pointee.row--;
                    }
                }
                case 1 -> {
                    if (pointee.row < rows - 1) {
                        pointee.row++;
                    }
                }
                case 2 -> {
                    if (pointee.col > 0) {
                        pointee.col--;
                    }
                }
                case 3 -> {
                    if (pointee.col < cols - 1) {
                        pointee.col++;
                    }
                }
            }
        }
    }

    public void calculatePoints() {
        for (Coupon coupon : coupons) {
            coupon.points = 0;
            for (Pointee pointee : pointees) {
                if (coupon.row == pointee.row && coupon.col == pointee.col) {
                    coupon.points++;
                }
            }
        }
    }

    public void redeemCoupons(int round) {
        if (round == 25 || round == 50 || round == 100) {
            for (Coupon coupon : coupons) {
                System.out.println("Coupon at [" + coupon.row + ", " + coupon.col + "] is worth " + coupon.points + " points");
            }
        }
    }

    public Coupon findMostValuableCoupon() {
        Coupon mostValuableCoupon = coupons.stream()
                .max(Comparator.comparing(Coupon::getPoints))
                .get();

        System.out.println("\nMost Valuable Coupon is at [" + mostValuableCoupon.row + ", " + mostValuableCoupon.col + "] with " + mostValuableCoupon.points + " points");
        return mostValuableCoupon;
    }
}
