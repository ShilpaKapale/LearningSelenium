package com.Testing.SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Description("Open the app vmo.com and get title")
    @Test
    public void test_Selenium(){

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
