package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Ex_07_OptionClass {

    EdgeOptions edgeOptions = new EdgeOptions();

    @Test
    @Owner("Parveen Chaudhary")
    @Description("Verify How to work with option Classes")
    public void testOptionClassSelenium(){
        // FirefoxOptions, ChromeOptions, SafariOptions

        // EdgeOptions -> It will help you set the browser
        // options to browsers
        // window - size
        // headless mode - there is not UI -> advantage - Fast Execution
        // full UI mode - default - UI browser
        // incognito mode - switch
        // start Max
        // add extensions - browsers
        // 100 + others , https , http
        // localstorage, download ?

        edgeOptions.addArguments("--window-size=1280,720");
        edgeOptions.addArguments("--incognito");


        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.google.com");

        driver.quit();

    }
}
