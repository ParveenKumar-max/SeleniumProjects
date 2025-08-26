package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_29_FileUpload {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeTest
            public void OpenBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("---guest");
        driver.manage().window().maximize();
    }

    @Test
    @Description("TC_Verify File Upload via selenium")
    @Owner("Parveen Chaudhary")
    public void testFileUpload(){

        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement element = driver.findElement(By.xpath("//input[@name='fileToUpload']"));

        String working_dir = System.getProperty("user.dir");
        // Above code will give you  C:\Users\Parveen\IdeaProjects\SeleniumProject_S
        String path_file = working_dir+"\\TestData.xml";
        element.sendKeys(path_file);

        driver.findElement(By.xpath("//input[@name='submit']"));
        System.out.println("File Uploaded Successfully");
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
