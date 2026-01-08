package com.ginandjuice;

import com.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By emailField = By.name("email");
    public By subscribeButton = By.xpath("//div[@id='subscribe']//button[@type='submit']");
    private By foundCouponPlacement = By.className("coupon-input");
    private By closeButton = By.className("close-button");

//    String coupon;

    public void fillEmailField(String email){
        scrollToElementJS(subscribeButton);
        find(emailField).sendKeys(email);
    }

    public void clickSubscribeButton(){
        click(subscribeButton);
    }

    public String getTheCoupon(){
        find(foundCouponPlacement);
        var foundCoupon = getText(foundCouponPlacement);
        return foundCoupon;
    }

    public void clickCloseButton(){
        click(closeButton);
    }
}
