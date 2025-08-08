package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_02_Assertion {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_02_Verify assertion, Actual Vs Expected")
    public void testselenium2(){

        WebDriver driver = new EdgeDriver();
        // Create New Session Endpoint - 16 digit Unique ID is also created.

         driver.get("https://www.google.com/");
        // Navigate the URL -> HTTP -->  GET the URL

        String ActualMatch = driver.getCurrentUrl();
        // Store URL in variable.


        Assert.assertEquals(ActualMatch, "https://www.google.com/");
        // Assert the URL - Validation - TestNG Assertions

        driver.quit();
        //Close the session



    }
}
