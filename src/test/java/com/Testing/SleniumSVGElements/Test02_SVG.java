package com.Testing.SleniumSVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test02_SVG {

    @Test(groups = "QA")
    @Description("Test case description")
    public void table() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.manage().window().maximize();

        List<WebElement> Elements= driver.findElements(By.xpath("//*[local-name()='svg']/*[name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
        for (WebElement state: Elements)
        {
            System.out.println(state.getAttribute("aria-label"));
//            if(state.getAttribute("aria-label").contains("Tripura")){
//                state.click();
//            }
        }
}
}