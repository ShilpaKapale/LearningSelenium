package com.Testing.SeleniumFileUpload;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test01_Fileupload {

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
        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileinput = driver.findElement(By.id("fileToUpload"));

        String workingdir = System.getProperty("user.dir");
        System.out.println(workingdir);

        uploadFileinput.sendKeys(workingdir+"/src/test/java/com/Testing/SeleniumFileUpload/Testdata.txt");
        driver.findElement(By.name("submit")).click();
    }
}
