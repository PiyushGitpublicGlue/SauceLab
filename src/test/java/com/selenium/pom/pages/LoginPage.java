package com.selenium.pom.pages;

import com.selenium.pom.base.BasePage;
import com.selenium.pom.objects.UserCred;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By getUserName = By.id("user-name");
    private By getUserPassword = By.id("password");
    private By clickLoginBtn = By.id("login-button");
    private By errorMsg = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load(){
        load("/");
        return this;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public LoginPage getUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUserName)).sendKeys(username);
        return this;
    }
    public LoginPage getUserPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUserPassword)).sendKeys(password);
        return this;
    }
    public ProductPage clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clickLoginBtn)).click();
        return new ProductPage(driver);
    }

    public String getErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }

    public ProductPage doLogin(UserCred user){
        getUserName(user.getUsername());
        getUserPassword(user.getPassword());
        clickLoginBtn();
        return new ProductPage(driver);
    }
}
