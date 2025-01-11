package com.Testing.SeleniumActionsclass;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test03_makemytrip {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        driver = new ChromeDriver(chromeOptions);
    }

    @Description("Verify actions")
    @Test

    public void Test() throws Exception {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait
                .until(
                        ExpectedConditions.
                                visibilityOfElementLocated(
                                        By.xpath("//span[@data-cy='closeModal']"
                                        )
                                )
                );

        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

       WebElement input = driver.findElement(By.id("fromCity"));
        Actions a = new Actions(driver);
        Thread.sleep(5000);
       a.moveToElement(input).click().sendKeys(input,"kanpur").build().perform();
         //a.moveToElement(input).click().sendKeys("kan").build().perform();

               Thread.sleep(5000);

           a.moveToElement(input).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
        List<WebElement> Elements = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li[@role=\"option\"]"));
        Thread.sleep(5000);
        System.out.println(Elements.size()); //Not fetching elements


        for (WebElement State : Elements) {
        System.out.println(State.getText());


        }
        }

        }
    
