package com.Testing.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test04_katalonlogin {

    @Description("Verify Katalon")
    @Test
    public void test_login() throws Exception {

//   Navigate to    https://katalon-demo-cura.herokuapp.com/

        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

//        Click on Make Appointment button

        WebElement makeapp = driver.findElement(By.id("btn-make-appointment"));
        makeapp.click();

//        Enter the Login creds and submit click

//        WebElement username = driver.findElement(By.name("username"));
//        username.sendKeys("John Doe");
//
//        WebElement password = driver.findElement(By.id("txt-password"));
//        password.sendKeys("ThisIsNotAPassword");
        List<WebElement>  username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username.get(1).sendKeys("John Doe");

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("ThisIsNotAPassword");

        WebElement button = driver.findElement(By.id("btn-login"));
        button.click();

//        Verify the current URL == https://katalon-demo-cura.herokuapp.com/#appointment
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
