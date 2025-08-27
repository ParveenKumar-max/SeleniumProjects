package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex_33_SeleniumExce01 {

    WebDriver driver = new EdgeDriver();

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_Verify Selenium Exception -- NoSuchElement")
    public void testSeleniumException(){

        driver.get("https://app.vwo.com/");
        System.out.println("Start of program");
        try {
            driver.findElement(By.id("pramod")); // org.openqa.selenium.NoSuchElementException: no such element
        } catch (NoSuchElementException e) {
            System.out.println("Element ila");
        }

    }

}
