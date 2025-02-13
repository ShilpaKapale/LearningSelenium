package com.Testing.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_vmologin {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
       // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //1. Find email input box and enter the mail id

        WebElement emailinputbox = driver.findElement(By.id("login-username"));
        emailinputbox.sendKeys("admin@admin.com");

        //2. Find password input box and enter the password

        WebElement passwordinputbox = driver.findElement(By.name("password"));
        passwordinputbox.sendKeys("admin");

        //3. Find the submit button and click it

        WebElement submitbutton = driver.findElement(By.id("js-login-btn"));
        submitbutton.click();
        Thread.sleep(3000);

        //4. Find the invalid error message and Verify
        WebElement errormessage = driver.findElement(By.className("notification-box-description"));
        System.out.println("Error message is: "+errormessage.getText());
       Assert.assertEquals(errormessage.getText(),"Your email, password, IP address or location did not match");

        Thread.sleep(5000);
        driver.quit();

    }
}
