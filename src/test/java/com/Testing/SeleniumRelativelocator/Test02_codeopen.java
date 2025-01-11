package com.Testing.SeleniumRelativelocator;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Test02_codeopen {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Actions")
    @Test
    public void test() throws InterruptedException
    {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        driver.switchTo().frame("result");
        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));

        submit.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement usernameerror = driver.findElement(with(By.tagName("small")).below(username));

        Assert.assertTrue(usernameerror.isDisplayed());
        String errortext = usernameerror.getText();
        Assert.assertEquals(errortext,"Username must be at least 3 characters");
        System.out.println("pass");

    }
}
