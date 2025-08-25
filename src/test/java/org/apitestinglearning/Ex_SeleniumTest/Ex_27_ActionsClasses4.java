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

import java.time.Duration;
import java.util.List;

public class Ex_27_ActionsClasses4 {

    WebDriver driver = new EdgeDriver();
    //Actions actions = new Actions(driver);
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
    public void testActionClass(){
  driver.get("https://www.makemytrip.com/");

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
  WebElement element  = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
  element.click();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-cy='fromCity']")));
  WebElement e1 = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
  e1.click();

  List<WebElement> element1 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        try {
            for (WebElement element2 : element1){
                if (element2.getText().contains("Bangkok")){
                    element2.click();
                }
                System.out.println(element2.getText());
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-cy='toCity']")));
  WebElement e2 = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
  e2.click();

  List<WebElement> element3 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        try {
            for (WebElement element4 : element3) {

                if (element4.getText().contains("Pune")){
                    element4.click();

                }
                System.out.println(element4.getText());

               }
        } catch (Exception e) {
            e.printStackTrace();
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
