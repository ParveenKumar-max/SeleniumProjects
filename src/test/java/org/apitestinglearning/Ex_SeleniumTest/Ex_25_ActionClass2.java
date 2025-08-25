package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Ex_25_ActionClass2 {


    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Action class MoveToElement, SendKeys, Build(), perform()")
    public void testActionClass2(){

    driver.get("https://www.spicejet.com/");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='to-testID-origin']")));

    WebElement element = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']"));

    actions.moveToElement(element).click().sendKeys("BLR").build().perform();

    WebElement element1 = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']"));
    actions.moveToElement(element1).click().sendKeys("DEL").build().perform();
    }
    @AfterTest
    public void CloseBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }



}
