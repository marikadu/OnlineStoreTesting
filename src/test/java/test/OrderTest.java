package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    String coupon;


    @Test
    public void placingOrderWithCouponTest() {

        // 1. Login
        var loginPage = homePage.logIntoAccount();
        loginPage.login();

//        // 2. Get the coupon
        homePage.fillEmailField("mail@mail.com");
        homePage.clickSubscribeButton();
        coupon = homePage.getTheCoupon(); // Save the coupon
        System.out.println("Found coupon: " + coupon);
        homePage.clickCloseButton();

        // 3. Add products to the shopping cart
        // 3.1 Get the number of all products
        var productsPage = homePage.goToProductsPage();
        String actualTitle = productsPage.getProductsPageTitle();
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(actualTitle,  expectedTitle, "\n Could not find the page title \n");
        productsPage.getNumberOfProducts(); // Find the number of products
        // 3.2 Open every product page and add them to the cart
        productsPage.goToProductPageAndAddToCart();
//
        // 4. Go to shopping cart page
        var shoppingCartPage = homePage.goToShoppingCartPage();

        var priceBeforeDiscount = shoppingCartPage.getPriceAsFloat(); // Getting the price before applying the discount

        shoppingCartPage.enterCoupon(coupon);
        shoppingCartPage.clickApplyCouponButton();
        shoppingCartPage.clickPlaceOrderButton();

        var priceAfterDiscount = shoppingCartPage.getPriceAsFloat(); // Getting the price after applying the discount

        // 5. Check the discount
        var calculatedPercentage = 100.0 - (priceAfterDiscount * 100 / priceBeforeDiscount);
        System.out.println("Calculated percentage: " + calculatedPercentage);

        Assert.assertEquals(calculatedPercentage, 20.0, "\n The discount does not match \n");
    }
}