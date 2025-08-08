package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex_03_PageSource {

    @Test
    @Owner("")
    @Description("Tc_03_Verify PageSource")
    public void testSelenium3(){

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");

        // Below are very important method in selenium
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());

        driver.quit();


    }
}
