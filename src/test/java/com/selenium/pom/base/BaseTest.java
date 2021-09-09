package com.selenium.pom.base;

import com.selenium.DriverFactory.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    //protected WebDriver driver;

    private ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void startDriver(){
        setDriver(new DriverManager().initializeDriver());
        System.out.println("CURRENT THREAD ID : "+Thread.currentThread().getId() + " , " +
                "DRIVER : " + getDriver());
    }

    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {
        System.out.println("CURRENT THREAD ID : "+Thread.currentThread().getId() + " , " +
                "DRIVER : " + getDriver());
        if(result.getStatus()== ITestResult.FAILURE){
            File destFile = new File("scr"+File.separator+result.getTestClass()
                    .getRealClass().getSimpleName()+"_"+result.getMethod().getMethodName()+".png");
            takeScreenShot(destFile);
        }
        getDriver().quit();
    }

    private void takeScreenShot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot =  (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destFile);
    }
}
