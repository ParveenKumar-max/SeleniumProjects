package org.apitestinglearning.Ex_SeleniumTest.DataDriven;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Ex_41_DDTNextStep {

    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test(dataProvider = "getData")
    @Owner("Parveen Chaudhary")
    @Description("TC__Verify login and Password multiple times with different credential -- DDT")
    public void testDataDrivenTesting(String email, String password){
       /* System.out.println(email + " || " + password + " || ");
        // String[] data = password.split("_");  you can use pipe char | till 5 while splitting*/


        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getTitle(), "VWO - Application");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        // 1. Find the email inputbox and enter the email
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(email);


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);


        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

    }

    //Pre-defined method in TestNG
    @DataProvider
    public Object[][] getData(){
        //Write code to read the excel file
        // Convert the data into Row and Coloumn in to the data[][]
        // retun new Object [][]

        return UtilExcel.getTestDataFromExcel("MOCK_DATA");
    }

}


