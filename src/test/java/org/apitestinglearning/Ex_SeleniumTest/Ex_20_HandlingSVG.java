package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ex_20_HandlingSVG {

    EdgeDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Handle SVG")
    public void testHandlingSVG(){

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebElement element1 = driver.findElement(By.xpath("//input[@name='q']"));
        element1.sendKeys("Boat");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']")));
        List<WebElement> elements = driver.findElements(By.xpath("//*[name()='svg']"));
        elements.get(0).click();

        List<WebElement> elementslist = driver.findElements(By.xpath("//div[@class='DOjaWF gdgoEp']//div//div[@class='_75nlfW']"));
        for (WebElement webElement : elementslist){
            System.out.println("List of All Boat products are" + elementslist.get(0).getText() + " || "+ "********");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-id, 'ACCFSDGXX3S6DVBG')]//div/a[2]")));
        WebElement element2 = driver.findElement(By.xpath("//div[contains(@data-id, 'ACCFSDGXX3S6DVBG')]//div/a[2]"));
        element2.click();
    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
