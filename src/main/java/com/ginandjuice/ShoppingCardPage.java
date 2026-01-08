package com.ginandjuice;

import org.openqa.selenium.By;

public class ShoppingCardPage extends ProductsPage {
    private By couponField = By.name("coupon");
    private By applyCouponButton = By.xpath("//form[@id='coupon-form']//button[text()='Apply']");
    private By placeOrderButton = By.xpath("//div[@class='cart-order-section']//button[text()='Place order']");

    public void enterCoupon(String coupon) {
        driver.findElement(couponField).sendKeys(coupon);
    }

    public void clickApplyCouponButton() {
        click(applyCouponButton);
    }

    public void clickPlaceOrderButton() {
        click(placeOrderButton);
    }

    // Additional: calculate the difference and check whether it is actually 20% discount
}
