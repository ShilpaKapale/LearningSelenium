package com.Testing.SleniumSVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test01_SVG {

    @Test(groups = "QA")
    @Description("Test case description")
    public void table() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]")).sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();


    }

}
