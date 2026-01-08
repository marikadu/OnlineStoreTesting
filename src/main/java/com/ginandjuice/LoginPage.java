package com.ginandjuice;

import org.openqa.selenium.By;

public class LoginPage extends HomePage{
    private By getCredentials = By.xpath("//span[text()!='Username']//text()[last()]");
    private By usernameField = By.name("username");
    private String username;
    private String cleanUsername;
    private By passwordField = By.xpath("//input[@name='password']");


    private By loginButton = By.xpath("//button[text()=\' Log in \']"); // <- There are spaces on the sides


//    public void getUserName() {
//        find(getCredentials);
//        username = getText(getCredentials);
//        cleanUsername = username.replaceAll(" ", ""); // Remove the space
//    }

    public void enterUserName() {
        driver.findElement(usernameField).sendKeys("carlos");
    }

    public void clickLoginButton() {
        click(loginButton);
    }


    public void enterPassword() {
        driver.findElement(passwordField).sendKeys("hunter2");
    }

    public void login(){

        enterUserName();
        clickLoginButton();

        enterPassword();
        clickLoginButton();
    }
}
