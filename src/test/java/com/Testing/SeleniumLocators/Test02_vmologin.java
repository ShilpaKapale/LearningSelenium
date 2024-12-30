package com.Testing.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Test02_vmologin {

    @Description("Verify the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage" class="text-link" data-qa="bericafeqo">Start a free trial</a>
        //WebElement freetrial = driver.findElement(By.linkText("Start a free trial"));
        //freetrial.click();

        WebElement freetrial = driver.findElement(By.partialLinkText("free trial"));
        freetrial.click();





    }
}