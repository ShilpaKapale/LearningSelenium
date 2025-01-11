package com.Testing.SeleniumWindows;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Test01_Internet {
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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String parentwindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowhandles = driver.getWindowHandles();
        for (String handle: windowhandles)
        {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window"))
            {
                System.out.println("Pass");
                break;
            }
        }
    }
}