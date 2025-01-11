package com.Testing.SeleniumActionsclass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test02_spicejet {
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
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

       WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
       //If element .click() does not work than go for Actions class

       Actions actions = new Actions(driver);
        actions.moveToElement(source).click().sendKeys("BLR").build().perform();
    }
}