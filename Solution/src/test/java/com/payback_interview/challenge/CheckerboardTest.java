package com.payback_interview.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CheckerboardTest {
    
    private Checkerboard underTest;

    @BeforeEach
    void setUp() {
        underTest = new Checkerboard();
    }

    @Test
    public void sendBirdHappyPathTest() {
        int initialPointeeCount = underTest.pointees.size();
        underTest.sendBird();
        int afterBirdCount = underTest.pointees.size();
        assertEquals(initialPointeeCount, afterBirdCount);

        for (Pointee pointee : underTest.pointees) {
            assertTrue(pointee.getRow() >= 0 && pointee.getRow() < underTest.rows);
            assertTrue(pointee.getCol() >= 0 && pointee.getCol() < underTest.cols);
        }
    }

    @Test
    public void redeemCouponsHappyPathTest() {
        Checkerboard checkerboard = new Checkerboard();
        ArrayList<Coupon> coupons = checkerboard.coupons;
        checkerboard.calculatePoints();

        checkerboard.redeemCoupons(25);
        assertEquals("Coupon at [0, 0] is worth 1 points", "Coupon at [0, 0] is worth " + coupons.get(0).points + " points");

        checkerboard.redeemCoupons(50);
        assertEquals("Coupon at [0, 0] is worth 1 points", "Coupon at [0, 0] is worth " + coupons.get(0).points + " points");

        checkerboard.redeemCoupons(100);
        assertEquals("Coupon at [0, 0] is worth 1 points", "Coupon at [0, 0] is worth " + coupons.get(0).points + " points");
    }

    @Test
    public void calculatePointsHappyPathTest() {
        underTest.calculatePoints();
        assertPointsAreZero();

        underTest.sendBird();
        underTest.calculatePoints();
        int sum = getTotalPoints();
        assertEquals(underTest.pointees.size(), sum);
    }

    @Test
    public void findMostValuableCouponHappyPathTest_ShouldCheckIfMostValuableCouponIsValid() {
        underTest.findMostValuableCoupon();
        assertMostValuableCouponIsValid();
    }

    private void assertPointsAreZero() {
        for (Coupon coupon : underTest.coupons) {
            assertEquals(1, coupon.getPoints());
        }
    }

    private int getTotalPoints() {
        int sum = 0;
        for (Coupon coupon : underTest.coupons) {
            sum += coupon.getPoints();
        }
        return sum;
    }

    private void assertMostValuableCouponIsValid() {
        Coupon mostValuableCoupon = underTest.findMostValuableCoupon();
        for (Coupon coupon : underTest.coupons) {
            assertTrue(coupon.getPoints() <= mostValuableCoupon.getPoints());
        }
    }
}
