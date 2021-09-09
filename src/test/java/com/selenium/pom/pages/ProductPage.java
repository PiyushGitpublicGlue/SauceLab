package com.selenium.pom.pages;

import com.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private By getProductPageTitle = By.xpath("//*[@class='title']");
    private By clickOnProductAddToCart = By.id("add-to-cart-sauce-labs-onesie");
    private By clickOnProductPage = By.id("item_1_title_link");
    private By getProductTitleOnProductPage = By.cssSelector(".inventory_details_name.large_size");
    private By clickOnMiniCartBtn = By.cssSelector(".shopping_cart_link");
    private By getProductTitleOnMiniCart = By.cssSelector(".inventory_item_name");
    private By clickOnCheckOutBtn = By.id("checkout");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getProductPageTitle)).getText();
    }

    public ProductPage clickOnProductAddToCart(String productName){
        By clickOnProductAddToCart = By.id("add-to-cart-sauce-labs-"+productName+"");
        wait.until(ExpectedConditions.elementToBeClickable(clickOnProductAddToCart)).click();
        return this;
    }
    public ProductPage clickOnProductPage(int productId){
        //By clickOnProductPage = By.id("item_"+productId+"_title_link");
        By clickOnProductPage = By.xpath("//*[@id='item_"+productId+"_title_link']//div");
        wait.until(ExpectedConditions.elementToBeClickable(clickOnProductPage)).click();
        return this;
    }
    public String getProductTitleOnProductPage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getProductTitleOnProductPage)).getText();
    }

    public ProductPage clickOnMiniCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMiniCartBtn)).click();
        return this;
    }

    public String getProductTitleOnMiniCart(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getProductTitleOnMiniCart)).getText();
    }

    public CheckoutPage clickOnCheckOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCheckOutBtn)).click();
        return new CheckoutPage(driver);
    }
}
