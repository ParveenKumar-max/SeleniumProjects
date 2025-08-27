package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex_31_CheckedException {

    WebDriver driver = new EdgeDriver();
    FileReader reader;

    @Test
    @Owner("Parveen Kumar")
    @Description("TC_Verify Checked / Compile Time")
    public void testCheckedExecption(){

        try {
            reader = new FileReader("C:\\Users\\Parveen\\IdeaProjects\\SeleniumProject_S\\Adblock.crx");
            BufferedReader bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }

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
