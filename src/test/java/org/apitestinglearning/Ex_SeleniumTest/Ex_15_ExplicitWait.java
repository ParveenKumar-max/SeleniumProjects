package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_15_ExplicitWait {


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Explicit Wait")
    public void testExplicitWait(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("http://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ABC")));

        driver.quit();

    }
}
