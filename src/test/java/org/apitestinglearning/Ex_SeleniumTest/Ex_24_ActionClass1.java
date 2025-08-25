package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ex_24_ActionClass1 {

    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Actions Classes keyDown, keyUp, Keys.shift, Keys.ALT")
    public void testActionProgram(){

        driver.get("https://awesomeqa.com/practice.html");

        WebElement element = driver.findElement(By.xpath("//input[@name='firstname']"));

        // Now we want to enter the capital name in the input type
        // So we will use Action Classes


        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(element, "Parveen")
                .keyUp(Keys.SHIFT).build().perform();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selenium_commands']")));

    List<WebElement> element1 = driver.findElements(By.xpath("//select[@id='selenium_commands']/option"));
        element1.get(3).click();

        for (WebElement element2 : element1){
            //element2.getText();
            System.out.println(element2.getText());
        }
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
