package com.selenium.pom.tests;
import com.selenium.pom.base.BaseTest;
import com.selenium.pom.objects.Product;
import com.selenium.pom.objects.UserCred;
import com.selenium.pom.objects.UserDetails;
import com.selenium.pom.pages.CheckoutPage;
import com.selenium.pom.pages.LoginPage;
import com.selenium.pom.pages.ProductPage;
import com.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {
    @Test
    public void placeOrderUsingExistingUserFromOutsideProduct() throws IOException {
        LoginPage loginPage = new LoginPage(getDriver()).load();
        UserCred userCred = new UserCred(1);
        UserDetails userDetails = new UserDetails(1);
        Product product = new Product(2);
        Assert.assertEquals(loginPage.getLoginPageTitle(), ConfigLoader.getInstance().loginPageExpectedTitle());
        ProductPage productPage = loginPage.doLogin(userCred);
        Assert.assertEquals(productPage.getProductPageTitle(),ConfigLoader.getInstance().productPageExpectedTitle());
        productPage.clickOnProductAddToCart(product.getProductName()).clickOnMiniCartBtn();
        Assert.assertEquals(productPage.getProductTitleOnMiniCart(),product.getProductTitle());
        CheckoutPage checkoutPage = productPage.clickOnCheckOutBtn();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(),ConfigLoader.getInstance().checkOutPageExpectedTitle());
        checkoutPage.doSubmitUserDetails(userDetails);
        Assert.assertEquals(checkoutPage.getCheckoutOverViewTitle(),ConfigLoader.getInstance().checkOutPageOverviewExpectedTitle());
        checkoutPage.submitCheckoutOverViewDetails();
        Assert.assertEquals(checkoutPage.getSuccessInformation(),ConfigLoader.getInstance().successInformationExpectedTitle());
    }

    @Test
    public void placeOrderUsingExistingUserFromInsideProduct() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver()).load();
        UserCred user1 = new UserCred(1);
        UserDetails userDetails3 = new UserDetails(3);
        Product product = new Product(5);
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Swag Labs");
        ProductPage productPage = loginPage.doLogin(user1);
        Assert.assertEquals(productPage.getProductPageTitle(),"PRODUCTS");
        productPage.clickOnProductPage(product.getProductId());
        Assert.assertEquals(productPage.getProductTitleOnProductPage(),product.getProductTitle());
        productPage.clickOnProductAddToCart(product.getProductName()).clickOnMiniCartBtn();
        Assert.assertEquals(productPage.getProductTitleOnMiniCart(),product.getProductTitle());
        CheckoutPage checkoutPage = productPage.clickOnCheckOutBtn();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(),"CHECKOUT: YOUR INFORMATION");
        checkoutPage.doSubmitUserDetails(userDetails3);
        Assert.assertEquals(checkoutPage.getCheckoutOverViewTitle(),"CHECKOUT: OVERVIEW");
        checkoutPage.submitCheckoutOverViewDetails();
        Assert.assertEquals(checkoutPage.getSuccessInformation(),"THANK YOU FOR YOUR ORDER");

    }
}
