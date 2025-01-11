package com.Testing.SeleniumFileUpload;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test02_Internet {
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
         driver.findElement(By.linkText("File Upload")).click();
        WebElement uploadFileinput = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
        Thread.sleep(3000);
        String workingdir = System.getProperty("user.dir");
        System.out.println(workingdir);

        uploadFileinput.sendKeys("C:/Users/Shilpa/Downloads/example.apk");
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
    }
}
