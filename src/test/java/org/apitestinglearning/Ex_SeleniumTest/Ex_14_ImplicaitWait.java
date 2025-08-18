package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Ex_14_ImplicaitWait {


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Implicit Wait")
    public void testImplicitWait(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); -- Selenium 3 old version, not supported.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // selenium 4




        driver.get("http://www.google.com");


        driver.quit();






    }

}
