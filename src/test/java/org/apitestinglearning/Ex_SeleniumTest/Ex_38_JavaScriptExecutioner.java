package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import javax.swing.*;

import java.time.Duration;

import static org.apitestinglearning.Ex_SeleniumTest.Ex_22_WaitHelpers.WaitCondition;

public class Ex_38_JavaScriptExecutioner {

    WebDriver driver;
    Actions actions;

    @BeforeTest
            public void OpenBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_Verify JavaScriptExecutioner")
    public void testJavascriptExecutioner(){
        // Another Way to Open the Web Browser
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.location = 'https://www.google.com/';");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Redirecting to SelectorHub URL.
        driver.get("https://selectorshub.com/xpath-practice-page/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Fetch the Title and URL i
        String CurrentURL = javascriptExecutor.executeScript("return document.URL;").toString();
        System.out.println(CurrentURL);
        String CurrentTitle = javascriptExecutor.executeScript("return document.title;").toString();
        System.out.println(CurrentTitle);

        wait.withTimeout(Duration.ofSeconds(20));

        WaitCondition(10000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1500)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='myFile']")));

        //document.querySelector('#userName').shadowRoot.querySelector('#app2').shadowRoot.querySelector('#pizza')

        WebElement inputboxPizza = (WebElement) javascriptExecutor.executeScript
                ("return document.querySelector(\"div#userName\")" +
                        ".shadowRoot.querySelector('div#app2')" +
                        ".shadowRoot.querySelector('#pizza');");


        wait.until(ExpectedConditions.visibilityOf(inputboxPizza));
        inputboxPizza.sendKeys("FarmHouse");


    }
    @AfterTest
    public void CloseBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }



}
