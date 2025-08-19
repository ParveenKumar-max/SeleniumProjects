package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex_18_CheckRadio {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify Checkbox, Radio")
    public void testCheckboxRadio(){


        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        // Input
        driver.findElement(By.name("firstname")).sendKeys("the testing academy");

        // RADIO Box
        driver.findElement(By.id("sex-1")).click();

        // CheckBox
        driver.findElement(By.id("tool-1")).click();




    }


}
