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

public class Ex_11_XpathSelenium {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("Verify Different xpath in selenium...")
    public void testXpathSelenium() throws InterruptedException {


        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

      //  driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = driver.findElement(By.id("login-username"));
        element.sendKeys("admin@admin.com");

        //Thread.sleep(2000);   never use thread, it will slow down the process.

        if(driver.getPageSource().contains("Sign in using SSO")){
            System.out.println("Text is visible");
        }else{
            System.out.println("Text is not visible");
        }

        WebElement element1 = driver.findElement
                (By.xpath("//button[@onClick='login.goToSSOView()']"));
        element1.click();


       /* WebElement element1 = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.partialLinkText("Sign in using SSO")));
        element1.click(); login.loginUsingSSO(event) */   // Explicit wait

        WebElement elementNext = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("sso-email"))
        );

        elementNext.clear();
        elementNext.sendKeys("123");


        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@id='js-sso-login-btn']")));
        element3.click();

        Thread.sleep(3000);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement element4 = driver.findElement(By.xpath("//div[@class='notification-box-description']"));
        String Actual = element4.getText();

        Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Assert.assertEquals(Actual, "Single Sign-On (SSO) is not enabled for your account. Enter the password to sign in.");

        System.out.println("Error is " + Actual);

        if(driver.getPageSource().contains("Back")){
            System.out.println("Back Text is visible");
        }else{
            System.out.println("Back Text is not visible");
        }

        Thread.sleep(3000);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Wait for Back element to be clickable

        WebElement element5 = driver.findElement
         (By.xpath("//button[contains(@class,'btn-link')]//span[normalize-space(text)='Back']"));

        element5.click();


        driver.quit();

    }


}
