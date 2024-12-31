package com.Testing.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Test07_vmo {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");


//        WebElement email = driver.findElement(By.xpath("//input[@id='login-username']"));
//        email.sendKeys("sdf");

//        WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
//        email.sendKeys("sdf");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='hocewoqisi']"));
        email.sendKeys("sdf");

        WebElement pass = driver.findElement(By.xpath("//input[@data-qa='jobodapuxe']"));
        pass.sendKeys("sdf");

        WebElement button = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        button.click();


    }
}
