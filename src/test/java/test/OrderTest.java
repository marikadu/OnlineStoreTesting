package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    String coupon;

    // 3. Place an order
    // 4. Confirm order

    @Test
    public void placingOrderWithCouponTest(){

        // 1. Get the coupon
        homePage.fillEmailField("mail@mail.com");
        homePage.clickSubscribeButton();
        coupon = homePage.getTheCoupon(); // Save the coupon
        System.out.println("Found coupon: " + coupon);
        homePage.clickCloseButton();

        // 2. Add products to the shopping cart
        // 2.1 Get the number of all products

        var productsPage = homePage.goToProductsPage();
        String actualTitle = productsPage.getProductsPageTitle();
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(actualTitle,  expectedTitle, "\n Could not find the page title \n");

        productsPage.getNumberOfProducts(); // Find the number of products

        // 2.2 Open every product page and add them to the cart
        productsPage.goToProductPageAndAddToCart();

        // 3. Go to cart page
    }
}
