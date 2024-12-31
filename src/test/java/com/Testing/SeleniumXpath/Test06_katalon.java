package com.Testing.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Test06_katalon {
    @Description("Verify Katalon")
    @Test
    public void test_login() throws Exception {

//   Navigate to    https://katalon-demo-cura.herokuapp.com/

        EdgeOptions edgeOptions = new EdgeOptions();
        // edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        // a tag
       // WebElement appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
       // appointment.click();

        // a tag
       // WebElement appointment = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
       // appointment.click();

        //All the HTML Elemenets
//       WebElement appointment = driver.findElement(By.xpath("//*[@href='./profile.php#login']"));
//        appointment.click();

        //Xpath Function - text()
//        WebElement appointment = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
//        appointment.click();

        //Xpath to normalize space if exsist in text
//        WebElement appointment = driver.findElement(By.xpath("//a[normalize-space()='Make Appointment']"));
//        appointment.click();

        //Partial Matching Text - contains()
//        WebElement appointment = driver.findElement(By.xpath("//a[normalize-space()='Make Appointment']"));
//        appointment.click();

        //Partial Matching Text - contains() with function
//        WebElement appointment = driver.findElement(By.xpath("//a[contains(text(),'Make')]"));
//        appointment.click();

        //Partial Matching Text - contains() with tag and it should have @
//        WebElement appointment = driver.findElement(By.xpath("//a[contains(@id,'btn-make-appointment')]"));
//        appointment.click();

        //Partial Matching Text - contains() with tag and it should have @
//        WebElement appointment = driver.findElement(By.xpath("//a[contains(@href,'./profile.php#login')]"));
//        appointment.click();

        //#### Operators - AND & OR
        WebElement appointment = driver.findElement(By.xpath("//a[text()='Make Appointment' and contains(@id,'btn-make-appointment')]"));
        appointment.click();

        //We can also do by label also ex: //label[text()="Email address"] for vmo app





    }
}
