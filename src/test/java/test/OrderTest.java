package test;

import base.BaseTest;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    String coupon;
    // 2. add things to shopping card
    // 3. place an order
    // 4. confirm order

    @Test
    public void placingOrderWithCouponTest(){

        // 1. Get the coupon
        homePage.fillEmailField("mail@mail.com");
        homePage.clickSubscribeButton();
        coupon = homePage.getTheCoupon(); // Save the coupon
        System.out.println("Found coupon:" + coupon);
        homePage.clickCloseButton();
    }
}
