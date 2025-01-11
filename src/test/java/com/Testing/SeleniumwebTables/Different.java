package com.Testing.SeleniumwebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;




import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Different {

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
//xpath //table[@id="customers"]/tbody/tr[5]/td[2]
            String firstpart = "//table[@id=\"customers\"]/tbody/tr[";
            // 5 --->i
            String secondpart = "]/td[";
            // 2 --->j
            String thirdpart ="]";

            int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
            int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

            for (int i = 2;i<=row;i++) {
                for (int j = 1; j<=col; j++) {
                    String dynamicpath = firstpart+i+secondpart+j+thirdpart;
                    //System.out.println(dynamicpath);
                    String data = driver.findElement(By.xpath(dynamicpath)).getText();
                    // System.out.println(data);
                    if(data.contains("Helen Bennett"))
                    {
                        String countrypath = dynamicpath+"/following-sibling::td";
                        String countrytext = driver.findElement(By.xpath(countrypath)).getText();
                        System.out.println("----");
                        System.out.println("Helen Bennett is in - "+ countrytext);
                        System.out.println("----");
                    }

                }
            }


            }
        }








