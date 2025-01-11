package com.Testing.SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class Test03_staleelement {
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
            // Stale - not fresh any more
             //       - This exception happens when the element is no longer attached to the DOM.(HTML Pages)

            //When does stale exception occurs
          //  1. Refresh
          //  2. DOM changes in SinGLE Page Application. (SPA)

                    // HTML Page (DOM) is not refreshed,
            // Driver will think that, element may or may not available now.
            // I have found the element before refresh.

            // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) - VueJS, AngularJS

            //Stale element will not throw error after fixing it using try catch
            //Interview: How to fix exception is using try catch and again refind element after DOM changes in code as we did in next line 43 which is done in 32 line

            search = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
            search.sendKeys("Testing"+ Keys.ENTER);

        } catch (StaleElementReferenceException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        //try catch helps in not breaking code...it will help to execute/run other code and handle exception gracefully
        System.out.println("End of program");

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
