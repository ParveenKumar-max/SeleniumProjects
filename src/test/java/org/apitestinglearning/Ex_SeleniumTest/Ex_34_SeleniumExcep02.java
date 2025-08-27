package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Ex_34_SeleniumExcep02 {

    WebDriver driver = new EdgeDriver();

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_Verify Selenium Exception -- StaleElement Reference Exception")
    public void testSeleniumException02() {

        driver.get("https://google.com");
        System.out.println("Start of program");

        WebElement search_input_box  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));


        System.out.println(driver.getWindowHandle());
        // It will print you random 16 digit unique code. 45F91B2CF876710C43EEFFB7CEDD9331

        driver.navigate().refresh();

        try {
            search_input_box.sendKeys("the testing academy"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException");
        }
        // org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found


        System.out.println(driver.getWindowHandle()); // 45F91B2CF876710C43EEFFB7CEDD9331
        System.out.println("End of program");

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