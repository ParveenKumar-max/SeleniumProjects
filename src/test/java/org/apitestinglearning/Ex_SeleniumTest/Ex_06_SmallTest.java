package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apitestinglearning.CommonToAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_06_SmallTest extends CommonToAll {


    @Test
    @Owner("")
    @Description("")
    public void testSeleniumSmallTest(){

        // Extends CommonToAll method.
        WebDriver driver = new EdgeDriver();
        OpenBrowser(driver, "https://katalon-demo-cura.herokuapp.com/");

        if (driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("Test Case Passed");
            Assert.assertTrue(true);
        }else {
            Assert.fail("Cura Healthcare is not available on page");
        }

        CloseBrowser(driver);


        driver.close(); // only close the browser
        driver.quit(); //  close the browser and session

        driver.navigate().to("https:google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
