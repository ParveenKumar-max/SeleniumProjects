package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex_04_MaxMinWindow {

    @Test
    @Owner("")
    @Description("Tc_04_Verify Page Min, Max, FullScreen")
    public void testSeleniumWindow(){


        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");

        //driver.manage().window().maximize();
        //driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        driver.quit();

    }
}
