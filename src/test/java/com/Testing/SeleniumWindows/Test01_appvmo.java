package com.Testing.SeleniumWindows;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Test01_appvmo {
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
        String URL = "https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String parentwindow = driver.getWindowHandle();
        List<WebElement> element=driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));
        Actions a = new Actions(driver);
        a.moveToElement(element.get(1)).click().build().perform();
        Thread.sleep(13000);

        Set<String> allhandles = driver.getWindowHandles();
        System.out.println(allhandles);
        for (String handle:allhandles)
        {
            if(!handle.equals(parentwindow))
            {
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickmap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
                clickmap.click();
            }
        }
    }
}