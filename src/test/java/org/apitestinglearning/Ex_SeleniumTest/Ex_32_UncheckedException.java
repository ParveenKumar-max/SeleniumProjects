package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.FileReader;

public class Ex_32_UncheckedException {

    //WebDriver driver = new EdgeDriver();


    @Test
    @Owner("Parveen Kumar")
    @Description("TC_Verify UnChecked / RunTime")
    public void testUncheckedExecption() {

        try {
            int a = 5;
            int b = 5 / 0;
            System.out.println(b);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
