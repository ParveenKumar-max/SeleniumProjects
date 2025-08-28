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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.apitestinglearning.Ex_SeleniumTest.Ex_22_WaitHelpers.WaitCondition;

public class Ex_37_WindowHandles {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeTest
    public void OpenBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC-Verify Window Handle")
    public void testWindowHandle() {

        driver.get("https://demowebshop.tricentis.com/");

        String Parent = driver.getWindowHandle();
        System.out.println(Parent);

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement element = driver.findElement(By.xpath("//div[@class='column follow-us']"));
        //   actions.moveToElement(element).build().perform();
        System.out.println("Page Scroll to Social Tabs" + element.getText());

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement fbElement = driver.findElement(By.xpath("//li[@class='facebook']"));
        fbElement.click();
        WebElement twitterElement = driver.findElement(By.xpath("//li[@class='twitter']"));
        twitterElement.click();


        // ✅ Use Actions to avoid ElementClickInterceptedException
       /* actions.moveToElement(fbElement).click().build().perform();
        actions.moveToElement(twitterElement).click().build().perform();*/

        WaitCondition(3000);

        /*wait.until(driver1 -> driver.getWindowHandles().size() > 1);*/


        Set<String> windowHandle = driver.getWindowHandles();
        System.out.println("Handles Windows"+ windowHandle);
        for (String Handle : windowHandle) {
            if (!Handle.equals(windowHandle)) {
                driver.switchTo().window(Handle);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                if (driver.getTitle().contains("Facebook")) {
                    System.out.println("Facebook Page is open" + Handle);
                }
                if (driver.getTitle().contains("Twittor")) {
                    System.out.println("Twittor Page is Open" + Handle);
                }
            }
            driver.switchTo().window(Parent);
        }
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