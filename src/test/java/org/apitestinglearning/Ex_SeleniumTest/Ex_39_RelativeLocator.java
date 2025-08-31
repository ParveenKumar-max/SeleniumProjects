package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apitestinglearning.Ex_SeleniumTest.Ex_22_WaitHelpers.WaitCondition;
import static org.openqa.selenium.support.locators.RelativeLocator.*;



import java.time.Duration;
import java.util.Set;

public class Ex_39_RelativeLocator {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_Verify Relative Locators new in Selenium 4")
    public void testRelativeLocators(){

        driver.get("https://rahulshettyacademy.com/practice-project");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-youtube']")));

        WebElement element = driver.findElement(By.xpath("//span[@class='fa fa-youtube']"));
        String Parent = driver.getWindowHandle();
        System.out.println("Parent Window Handle" + Parent);

        // If you want click on Right of locator then you have select with(By.id("")).toRightof(element))
        // Use Relative Locator properly
       driver.findElement(with(By.tagName("span")).toRightOf(element)).click();

       WaitCondition(3000);

        Set<String> AllHandles = driver.getWindowHandles();
        System.out.println("Get All Windows" + AllHandles);

        for (String Handle : AllHandles){
            driver.switchTo().window(Handle);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

              String Title =   driver.getTitle();
               String URL =    driver.getCurrentUrl();

          if (Title.contains("LinkedIn") || URL.toLowerCase().contains("linkedin")){
              System.out.println("Linkdin Page Found || " + Title);
              break;
          }
        }
        driver.switchTo().window(Parent);
    }
    @AfterTest
    public void CloseBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    }


