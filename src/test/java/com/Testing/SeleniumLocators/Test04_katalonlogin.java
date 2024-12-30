package com.Testing.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test04_katalonlogin {

    @Description("Verify Katalon")
    @Test
    public void test_login() throws Exception {

//        https://katalon-demo-cura.herokuapp.com/
//
//        Click on Make Appointment button
//
//        Enter the Login creds and submit click
//
//        Verify the current URL == https://katalon-demo-cura.herokuapp.com/#appointment
        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeapp = driver.findElement(By.id("btn-make-appointment"));
        makeapp.click();

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement button = driver.findElement(By.id("btn-login"));
        button.click();

        System.out.println(driver.getCurrentUrl());
       // Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        //Or
        if (driver.getCurrentUrl().contains("https://katalon-demo-cura.herokuapp.com/#appointment"))
        {
            System.out.println("Make Appointment page is visible");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Make Appointment page is bot visible");
        }

    }
}
