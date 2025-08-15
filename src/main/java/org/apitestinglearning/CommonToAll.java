package org.apitestinglearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonToAll {

    public EdgeDriver driver;

    public void OpenBrowser(WebDriver driver, String url){

        driver.get(url);
        driver.manage().window().maximize();

    }

    public void CloseBrowser(WebDriver driver){

        driver.quit();

    }




}
