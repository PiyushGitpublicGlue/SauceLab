package com.selenium.pom.tests;
import com.selenium.pom.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstInitialTestCase extends BaseTest {
    //@Test
    public void placeOrderUsingExistingUserFromOutsideProduct(){
        getDriver().get("https://www.saucedemo.com/");
        Assert.assertEquals(getDriver().getTitle(),"Swag Labs");
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//*[@class='title']")).getText(),"PRODUCTS");
        getDriver().findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        getDriver().findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".inventory_item_name")).getText(),"Sauce Labs Onesie");
        getDriver().findElement(By.id("checkout")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".title")).getText(),"CHECKOUT: YOUR INFORMATION");
        getDriver().findElement(By.id("first-name")).sendKeys("Testfirstswag");
        getDriver().findElement(By.id("last-name")).sendKeys("Testlastswag");
        getDriver().findElement(By.id("postal-code")).sendKeys("110001");
        getDriver().findElement(By.id("continue")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".title")).getText(),"CHECKOUT: OVERVIEW");
        getDriver().findElement(By.id("finish")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".complete-header")).getText(),"THANK YOU FOR YOUR ORDER");

    }
    //@Test
    public void placeOrderUsingExistingUserFromInsideProduct(){

        getDriver().get("https://www.saucedemo.com/");
        Assert.assertEquals(getDriver().getTitle(),"Swag Labs");
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//*[@class='title']")).getText(),"PRODUCTS");
        getDriver().findElement(By.xpath("//*[@id='item_1_title_link']//div")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".inventory_details_name.large_size")).getText(),"Sauce Labs Bolt T-Shirt");
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        getDriver().findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".inventory_item_name")).getText(),"Sauce Labs Bolt T-Shirt");
        getDriver().findElement(By.id("checkout")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".title")).getText(),"CHECKOUT: YOUR INFORMATION");
        getDriver().findElement(By.id("first-name")).sendKeys("Testfirstswag");
        getDriver().findElement(By.id("last-name")).sendKeys("Testlastswag");
        getDriver().findElement(By.id("postal-code")).sendKeys("110001");
        getDriver().findElement(By.id("continue")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".title")).getText(),"CHECKOUT: OVERVIEW");
        getDriver().findElement(By.id("finish")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".complete-header")).getText(),"THANK YOU FOR YOUR ORDER");

    }
}
