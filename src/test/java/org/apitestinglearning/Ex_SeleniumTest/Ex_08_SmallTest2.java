package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Ex_08_SmallTest2 {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("Verify Youtube working without adds")
    public void testSmallTest2() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();  // It won't open the browser,
        // for the browser you have to write the WebDriver code.


        edgeOptions.addArguments("--window-size=1280,720");
       // edgeOptions.addExtensions(new File("src/test/java/org/apitestinglearning/Ex_SeleniumTest/Adblock.crx"));


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");

        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
