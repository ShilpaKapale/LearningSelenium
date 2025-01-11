package com.Testing.SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test03_timeoutexception {
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

        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();
            WebElement search = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
            driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='abc']")));
//Why we are not getting staleelement exception
            //We are not searching for exception but hereh we are checking for visibility of element and time is done then we get Timeoutexception
            //Whn we are searching for element and element notfound than its no such element excpetion we get
            WebElement search_inputbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            search_inputbox.sendKeys("the testing academy");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());;
        }

        System.out.println("end of program");

    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
