package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Ex_36_WindowHandle {


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
    @Description("TC-Verify Window Handle")
    public void testWindowHandle(){

        driver.get("https://the-internet.herokuapp.com/windows");

        String Parent = driver.getWindowHandle();
        System.out.println(Parent);


        WebElement element = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        element.click();

        Set<String> windowHandle = driver.getWindowHandles();

        for (String Handle : windowHandle){
            driver.switchTo().window(Handle);
                    if(driver.getPageSource().contains("New Window")){
                        System.out.println("Child Window Open successfully");

                    }
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
