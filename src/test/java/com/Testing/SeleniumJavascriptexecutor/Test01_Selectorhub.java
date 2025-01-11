package com.Testing.SeleniumJavascriptexecutor;

import io.qameta.allure.Description;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test01_Selectorhub {
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
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement elementtoscroll = driver.findElement(By.xpath("//div[@id='userName']"));

       // js.executeScript("arguments[0].scrollIntoView(true);",elementtoscroll);
        js.executeScript("window.scrollTo(0,1000)");




    }
}
