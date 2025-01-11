package com.Testing.SeleniumwebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test01_webtable_static {

    @Test(groups="QA")
    @Description("Test case description")
    public void table() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

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
