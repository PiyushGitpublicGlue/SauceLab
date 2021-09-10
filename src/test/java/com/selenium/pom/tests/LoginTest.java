package com.selenium.pom.tests;

import com.selenium.pom.base.BaseTest;
import com.selenium.pom.objects.UserCred;
import com.selenium.pom.pages.LoginPage;
import com.selenium.pom.pages.ProductPage;
import com.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTestWithValidUser() throws IOException {
    LoginPage loginPage = new LoginPage(getDriver()).load();
    UserCred userCred = new UserCred(1);
    Assert.assertEquals(loginPage.getLoginPageTitle(), ConfigLoader.getInstance().loginPageExpectedTitle());
    ProductPage productPage = loginPage.doLogin(userCred);
    Assert.assertEquals(productPage.getProductPageTitle(),ConfigLoader.getInstance().productPageExpectedTitle());
    }
    //@Test
    public void loginTestWithInValidUser() throws IOException {
        LoginPage loginPage = new LoginPage(getDriver()).load();
        UserCred userCred = new UserCred(2);
        Assert.assertEquals(loginPage.getLoginPageTitle(), ConfigLoader.getInstance().loginPageExpectedTitle());
        ProductPage productPage = loginPage.doLogin(userCred);
        Assert.assertEquals(loginPage.getErrorMessage(),ConfigLoader.getInstance().errorMessageExpectedTitle());
    }
}
