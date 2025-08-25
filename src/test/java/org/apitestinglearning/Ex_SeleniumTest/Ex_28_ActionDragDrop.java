package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apitestinglearning.Ex_SeleniumTest.Ex_22_WaitHelpers.WaitCondition;

public class Ex_28_ActionDragDrop {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Actions Classes")
    public void testActionClass() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement col = driver.findElement(By.xpath("//div[@id='columns']"));
        WebElement row = driver.findElement(By.xpath("//div[@id='column-b']"));

        WaitCondition(3000);

        actions.dragAndDrop(col, row).build().perform();
        actions.dragAndDrop(row,col).build().perform();


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
