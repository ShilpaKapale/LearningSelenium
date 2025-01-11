package com.Testing.SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Test03_nosuchelement {
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
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        try {
            driver.findElement(By.id("Hindi"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.get("https://google.com");

//Nosuchelement will still give error message even u fix using try catch

    }
}
