package com.Testing.SeleniumwebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test03_webtable_dynamic {

    @Test(groups="QA")
    @Description("Test case description")
    public void table() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");

        //2. Find password input box and enter the password

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Hacker@4321");

        //3. Find the submit button and click it

        WebElement loginbutton = driver.findElement(By.xpath("//button[text()=' Login ']"));
        loginbutton.click();
        Thread.sleep(3000);
//xpath = //div[contains(@class,'oxd-table-body')]/div/div/div[3]/div[1]

      int row = driver.findElements(By.xpath("//div[contains(@class,'oxd-table-body')]/div")).size();
      System.out.println(row);

      int col =driver.findElements(By.xpath("//div[contains(@class,'oxd-table-header')]/div/div/div")).size();
        System.out.println(col);
            List<WebElement> colelement = driver.findElements(By.xpath("//div[contains(@class,'oxd-table-body')]/div/div[1]/div/following-sibling::div"));
            String dynamicpath = "//div[contains(@class,'oxd-table-body')]/div/div[1]/div";
                    for (WebElement e :colelement)
                    {

                        if (e.getText().contains("0182")) {
                           System.out.println(e.getText());

                        }
                    }
                }





 }
