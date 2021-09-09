package com.selenium.pom.pages;

import com.selenium.pom.base.BasePage;
import com.selenium.pom.objects.UserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    private By getCheckoutPageTitle = By.xpath("//*[@class='title']");
    private By getUserFirstName = By.id("first-name");
    private By getUserLastName = By.id("last-name");
    private By getPostalCode = By.id("postal-code");
    private By submitUserDetailsBtn = By.id("continue");
    private By getCheckoutOverViewTitle = By.cssSelector(".title");
    private By getSuccessInformation = By.cssSelector(".complete-header");
    private By submitCheckoutOverViewDetails = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getCheckoutPageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckoutPageTitle)).getText();
    }

    public CheckoutPage getUserFirstName(String firstName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(getUserFirstName)).sendKeys(firstName);
        return this;
    }
    public CheckoutPage getUserLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUserLastName)).sendKeys(lastName);
        return this;
    }

    public CheckoutPage getPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPostalCode)).sendKeys(postalCode);
        return this;
    }


    public CheckoutPage submitUserDetailsBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(submitUserDetailsBtn)).click();
        return this;
    }

    public CheckoutPage doSubmitUserDetails(UserDetails userDetails){
        getUserFirstName(userDetails.getUserFirstName());
        getUserLastName(userDetails.getUserLastName());
        getPostalCode(userDetails.getPostalCode());
        submitUserDetailsBtn();
        return this;
    }
    public String getCheckoutOverViewTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckoutOverViewTitle)).getText();
    }
    public String getSuccessInformation(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getSuccessInformation)).getText();
    }
    public CheckoutPage submitCheckoutOverViewDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(submitCheckoutOverViewDetails)).click();
        return this;
    }
}
