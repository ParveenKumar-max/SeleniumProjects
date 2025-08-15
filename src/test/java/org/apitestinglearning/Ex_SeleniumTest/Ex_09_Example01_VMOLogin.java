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


public class Ex_09_Example01_VMOLogin {

    @Test
    @Owner("")
    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    public void testSeleniumTest3() throws InterruptedException {


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement element1 = driver.findElement(By.id("login-username"));
        element1.sendKeys("admin@admin.com");

        WebElement element2 = driver.findElement(By.id("login-password"));
        element2.sendKeys("123456");

        WebElement element3 = driver.findElement(By.id("js-login-btn"));
        element3.click();

        WebElement element4 = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(element4.getText());

        Thread.sleep(3000);

        Assert.assertEquals(element4.getText(), "Your email, password, IP address or location did not match");

        driver.quit();












    }
}
