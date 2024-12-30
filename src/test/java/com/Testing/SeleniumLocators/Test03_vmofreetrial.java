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

public class Test03_vmofreetrial {

    @Description("Verify the free trial")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial");

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("3442345nnn");

        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

        List<WebElement> listbutton = driver.findElements(By.tagName("button"));
        listbutton.get(0).click();

        WebElement errormessage = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(errormessage.getText(),"The email address you entered is incorrect.");

    }
}
