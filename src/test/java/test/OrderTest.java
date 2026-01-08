package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    String coupon;

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

        // 2. Add products to the shopping cart
        var productsPage = homePage.goToProductsPage();
        String actualTitle = productsPage.getProductsPageTitle();
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(actualTitle,  expectedTitle, "\n Could not find the page title \n");

        productsPage.getNumberOfProducts(); // Find the number of products
    }
}
