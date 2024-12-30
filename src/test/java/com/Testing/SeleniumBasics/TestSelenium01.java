package com.Testing.SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Description("Open the app vmo.com and get title")
    @Test
    public void test_Selenium() throws Exception {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://app.vwo.com");
        System.out.println(driver.getTitle());
        if (driver.getPageSource().contains("Sign in to VWO platform"))
        {
            System.out.println("Sign in to VWO platform is visible");
            Assert.assertTrue(true);
        }
        else {
            throw new Exception("Sign in to VWO platform is not visible");
        }
        driver.close();
        WebDriver driver1 = new EdgeDriver();
        driver1.get("http://google.com");
        driver1.manage().window().maximize();
        System.out.println(driver1.getTitle());
        System.out.println(driver1.getCurrentUrl());
        Assert.assertEquals(driver1.getTitle(),"Google");


    }

}
