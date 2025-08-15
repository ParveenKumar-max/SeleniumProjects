package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_10_LoginDiffLocators {


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    public void testDifferentLocators(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement element = driver.findElement(By.linkText("Start a free trial"));
        element.click();

        WebElement element1 = driver.findElement(By.name("email"));
        element1.sendKeys("admin");

        WebElement element2 = driver.findElement(By.name("gdpr_consent_checkbox"));
        element2.click();

        WebElement element3 = driver.findElement(By.className("invalid-reason"));
        System.out.println(element3.getText());

        Assert.assertEquals(element3.getText(),"The email address you entered is incorrect.");


        driver.quit();

    }
}
