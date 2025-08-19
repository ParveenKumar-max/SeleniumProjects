package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_17_MiniWaitProject {


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Mini Projet and Use all Waits")
    public void testMiniProject(){

        // Locators - Find the Web elements
        // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        //Find the Email id** and enter the email as admin@admin.com
        //Find the pass inputbox** and enter passwrod as admin.
        //Find and Click on the submit button
        //Verify that the error message is shown "Your email, password, IP address or location did not match"


        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

      WebElement element1 =  driver.findElement(By.xpath("//input[@id='login-username']"));
      element1.sendKeys("admin@admin.com");

        WebElement element2 =  driver.findElement(By.xpath("//input[@id='login-password']"));
        element2.sendKeys("password123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkbox-radio-button ng-scope']")));

        WebElement element3 =  driver.findElement(By.xpath("//span[@class='checkbox-radio-button ng-scope']"));
        element3.click();

        WebElement element4 =  driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        element4.click();

        // Use Explicit Wait

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-notification-box-msg']")));

        WebElement element5 = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        String  Actual = element5.getText();
        System.out.println(Actual);

        String Expected = "Your email, password, IP address or location did not match";


        Assert.assertEquals(Actual, Expected);

        driver.quit();
   }

}
