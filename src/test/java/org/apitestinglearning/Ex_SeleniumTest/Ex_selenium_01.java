package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Ex_selenium_01 {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_01_Verify browser")
    public void testFirstSeleniumMethod(){


         // Webdriver is an interface,
         // Interfaces cannot be instantiated using new unless you implement all their methods.
         //   WebDriver webDriver = new WebDriver() {

        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://app.vwo.com");
        String title = webDriver.getTitle();
        System.out.println("Page Title is " + " " + title);
        webDriver.quit();

    }

}
