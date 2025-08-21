package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Ex_19_Selecbox {


    EdgeDriver driver = new EdgeDriver();

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Selectbox")
    public void testSelectbox(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();



        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);
//        select.selectByIndex(1);
//        select.selectByVisibleText("Option 1");
        select.selectByValue("2");
    }
    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
