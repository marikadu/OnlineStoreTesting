package com.ginandjuice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends HomePage{
    private By productsPageTitle = By.xpath("//h1[text()='Products']");
    private By productDetailsButton = By.xpath("//section[@class='maincontainer']//span[@class='button']");
    int amount;

    private By addToCartButton = By.xpath("//form[@id='addToCartForm']//button[@class='button']");

    // 1. Find the Number of products
    // 2. Create a loop through all the products to place all of them into the shopping card

    public String getProductsPageTitle(){
        return find(productsPageTitle).getText();
    }

    public void getNumberOfProducts(){
        List<WebElement> productButtons = driver.findElements(productDetailsButton);
        amount = productButtons.size();
        System.out.println("Number of products: " + amount);
    }

    public void goToProductPageAndAddToCart(){
        var i = 1;
        while (i <= amount){
            driver.get("https://ginandjuice.shop/catalog/product?productId=" + i);
            scrollToElementJS(addToCartButton);
            click(addToCartButton);
            i++;
        }

    }
}
