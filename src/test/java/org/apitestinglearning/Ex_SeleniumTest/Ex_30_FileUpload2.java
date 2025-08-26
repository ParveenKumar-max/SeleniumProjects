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

import static org.apitestinglearning.Ex_SeleniumTest.Ex_22_WaitHelpers.WaitCondition;

public class Ex_30_FileUpload2 {

    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void OpenBrowser(){
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_Verfiy File Upload in Browserstack")
    public void testFileupload1(){

driver.get("https://www.browserstack.com/users/sign_in");

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.findElement(By.id("user_email_login")).sendKeys("parveendogra2@gmail.com");
driver.findElement(By.id("user_password")).sendKeys("Parveen123@");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Sign me in']")));
driver.findElement(By.xpath("//input[@value='Sign me in']")).click();

WaitCondition(3000);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Get Started')]")));

WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Get Started')]"));
    element.click();

WebElement element1 = driver.findElement(By.xpath("//button[@id='upload-app']"));
    element1.click();

WebElement element2 = driver.findElement(By.xpath("//*[contains(text(), 'Upload a file')]"));
    element2.click();


String working_dir = System.getProperty("user.dir");

String Path_dir = working_dir+"//testdroid-sample-app.apk";

        element2.sendKeys(Path_dir);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-app__body__details'][contains(text(),'v0.3')]")));
WebElement element3 = driver.findElement(By.xpath("//div[@class='selected-app__body__details' and contains(text(),'v0.3')]"));

        System.out.println("APK successfully uploaded" + element3.getText());

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
