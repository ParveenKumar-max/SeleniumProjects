package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Ex_05_Assert_assertJ {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_05_Verify TestNG AssertJ")
    public void testAssert_AssertJ(){

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");

        String Actual = driver.getCurrentUrl();

        // aseert is java in built function
        Assert.assertEquals(Actual, "https://www.google.com/");

        //testng assertion
        assertThat(driver.getCurrentUrl()).isNotNull().isEqualTo("https://www.google.com/");

        driver.quit();

    }

}
