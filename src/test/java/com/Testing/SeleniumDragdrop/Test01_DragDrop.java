package com.Testing.SeleniumDragdrop;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test01_DragDrop {
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
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Drag and Drop")).click();

        Actions actions = new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(from,to).build().perform();

        //actions.moveToElement(from).moveToElement(to).release(to).build().perform();

    }
}
