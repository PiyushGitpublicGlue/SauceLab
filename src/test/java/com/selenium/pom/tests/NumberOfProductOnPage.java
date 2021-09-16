package com.selenium.pom.tests;

import com.selenium.pom.base.BaseTest;
import com.selenium.pom.objects.UserCred;
import com.selenium.pom.pages.LoginPage;
import com.selenium.pom.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfProductOnPage extends BaseTest {

    @Test
    public void getNumberOfProductOnPage() throws IOException {
        UserCred userCred = new UserCred(1);
        ProductPage loginPage = new LoginPage(getDriver()).load().doLogin(userCred);
        int numberOProductsOnPage = getDriver().findElements(By.cssSelector(".inventory_item_name")).size();
        System.out.println("No. of Products on Page : " + numberOProductsOnPage);
        getDriver().findElement(By.cssSelector(".product_sort_container")).click();
        Select sl = new Select(getDriver().findElement(By.cssSelector(".product_sort_container")));
        sl.selectByValue("lohi");
        List<WebElement> listOfProduct = getDriver().findElements(By.cssSelector(".inventory_item_name"));
        List<String> productNameList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(WebElement list:listOfProduct){
            //productNameList.add(list.getText());
            String rvs = list.getText();
            for(int i=rvs.length()-1;i>0;i--){
                sb.append(rvs.charAt(i));
            }
            productNameList.add(sb.toString());
        }

        for (String str:productNameList){
            System.out.println(str);
        }

    }

    @Test
    public void random() throws IOException {
        UserCred userCred = new UserCred(1);
        ProductPage loginPage = new LoginPage(getDriver()).load().doLogin(userCred);
        int numberOProductsOnPage = getDriver().findElements(By.cssSelector(".inventory_item_name")).size();
        System.out.println("No. of Products on Page : " + numberOProductsOnPage);
        //Select sl = new Select(getDriver().findElement(By.cssSelector(".product_sort_container")));
        //sl.selectByValue("lohi");
        List<WebElement> listOfProduct = getDriver().findElements(By.cssSelector(".inventory_item_price"));
        List<String> productNameList = new ArrayList<>();
        //StringBuilder sb = new StringBuilder();
        for(WebElement list:listOfProduct){
            productNameList.add(list.getText());

        } Collections.sort(productNameList);

        for (String str:productNameList){
            System.out.println(str);
        }
    }

}
