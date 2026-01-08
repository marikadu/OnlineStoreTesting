package com.ginandjuice;

import org.openqa.selenium.By;

public class ShoppingCardPage extends ProductsPage {
    private By couponField = By.name("coupon");
    private By applyCouponButton = By.xpath("//form[@id='coupon-form']//button[text()='Apply']");
    private By placeOrderButton = By.xpath("//div[@class='cart-order-section']//button[text()='Place order']");

    private By pricePlacement = By.xpath("//div[@class='cart-order-section']//strong");
    String beforeDiscountPrice;
    int priceFloat;


    public void enterCoupon(String coupon) {
        driver.findElement(couponField).sendKeys(coupon);
    }

    public void clickApplyCouponButton() {
        click(applyCouponButton);
    }


    public void clickPlaceOrderButton() {
        click(placeOrderButton);
    }

    public float getPriceAsFloat() {
        String foundPrice = getText(pricePlacement);
        String cleanPrice = foundPrice.replaceAll("[$,]", "");
        float newPrice = Float.parseFloat(cleanPrice);
        System.out.println(newPrice);
        return newPrice;
    }
}

