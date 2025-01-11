package com.Testing.SeleniumActionsclass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;

public class Test01_Awesomeqa {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify actions")
    @Test

    public void Test() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.name("firstname"));

        Actions a = new Actions(driver);

        a.keyDown(Keys.SHIFT).sendKeys(firstname,"testing").keyUp(Keys.SHIFT).build().perform();

    }
}