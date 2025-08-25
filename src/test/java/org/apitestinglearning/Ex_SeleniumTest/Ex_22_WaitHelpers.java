package org.apitestinglearning.Ex_SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

public class Ex_22_WaitHelpers {


    public static void WaitCondition(int Time){
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void CheckVisibility(WebDriver driver, int Time, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void CheckElementToBePresent(WebDriver driver, WebElement element, int Time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Full context"));
    }


}
