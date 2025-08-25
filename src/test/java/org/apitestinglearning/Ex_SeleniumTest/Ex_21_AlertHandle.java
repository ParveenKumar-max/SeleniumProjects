package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_21_AlertHandle {

    EdgeDriver driver = new EdgeDriver();
    Alert alert;

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Alert Function")
    public void testAlertHandle() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));

       WebElement element1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
       element1.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        WebElement element2 = driver.findElement(By.id("result"));
        String Actual = element2.getText();
        System.out.println(Actual);

        Assert.assertEquals(Actual, "You successfully clicked an alert");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='jsConfirm()']")));


        WebElement element3 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        element3.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.dismiss();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        WebElement element4 = driver.findElement(By.id("result"));
        String Actual1 = element4.getText();
        System.out.println(Actual1);

        Assert.assertEquals(Actual1, "You clicked: Cancel");

        WebElement element5 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        element5.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.dismiss();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        WebElement element6 = driver.findElement(By.id("result"));
        String Actual2 = element4.getText();
        System.out.println(Actual2);

        Assert.assertEquals(Actual2, "You clicked: Cancel");






        }

    @AfterTest
    public void CloseBrowser(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }



}