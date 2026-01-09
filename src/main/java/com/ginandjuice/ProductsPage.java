package com.ginandjuice;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductsPage extends HomePage{
    private By productsPageTitle = By.xpath("//h1[text()='Products']");
    private By productDetailsButton = By.xpath("//section[@class='maincontainer']//span[@class='button']");
    private By addToCartButton = By.xpath("//form[@id='addToCartForm']//button[@class='button']");
    public String getProductsPageTitle(){
        return find(productsPageTitle).getText();
    }
    private By productNamePlacement = By.xpath("//section[@class='product']//h3");

    int amount;
    private int productId = 1;
    private String productNameWithSpaces;
    private String productName;


    // 1. Find the Number of products
    public void getNumberOfProducts(){
        List<WebElement> productButtons = driver.findElements(productDetailsButton);
        amount = productButtons.size();
        System.out.println("Number of products: " + amount);
    }

    // 2. Create a loop through all the products to place all of them into the shopping card
    public void goToProductPageAndAddToCart(){
        while (productId <= amount){
            driver.get("https://ginandjuice.shop/catalog/product?productId=" + productId);
            getProductName();

            takeScreenshot(productName); // Take screenshot of every product
            // Additionally: calculate the price
            scrollToElementJS(addToCartButton);
            click(addToCartButton);
            productId++;
        }
    }


    private String getProductName(){
        find(productNamePlacement);
        productNameWithSpaces = getText(productNamePlacement);
        productName = productNameWithSpaces.replaceAll("[ ]", "_");
        return productName;
    }


    public void takeScreenshot(String productName){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/"
                + java.time.LocalDate.now().toString() + "_productId_" + productId + "_" + productName + ".png");

        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot located at: " + destination);
    }
}
