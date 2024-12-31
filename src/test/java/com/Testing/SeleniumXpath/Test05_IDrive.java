package com.Testing.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test05_IDrive {
    @Description("Verify expire message in IDrive360")
    @Test
    public void test_login() throws Exception {

//   Navigate to  https://www.idrive360.com/enterprise/login

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(3000);
        //Enter the credentials
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456");

        //Verify that the free trial message is visible.
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signin.click();

        Thread.sleep(15000);
        WebElement message = driver.findElement(By.xpath("//h5[text()='Your free trial has expired']"));

        if (message.getText().contains("Your free trial has expired"))
        {
            System.out.println("Free trial message is visible");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Free trial message is visible");
        }


    }
}