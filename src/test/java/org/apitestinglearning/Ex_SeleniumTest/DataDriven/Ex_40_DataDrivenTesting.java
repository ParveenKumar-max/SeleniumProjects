package org.apitestinglearning.Ex_SeleniumTest.DataDriven;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Ex_40_DataDrivenTesting {  // TestNG Provider

    @Test(dataProvider = "getdata")
    @Owner("Parveen Chaudhary")
    @Description("TC__Verify login and Password multiple times with different credential -- DDT")
    public void testDataDrivenTesting(String email, String passowrd){
        System.out.println(email + " || " + passowrd + " || ");

    }

    //Pre-defined method in TestNG
    @DataProvider
    public Object[][] getdata(){
        return new Object[][]{
                new Object[]{"admin@admin123", "password1"},
                new Object[]{"admin@admin123", "password1"},
                new Object[]{"admin@admin123", "password1"},
                new Object[]{"admin@admin123", "password1"},
                new Object[]{"admin@admin123", "password1"},
                new Object[]{"admin@admin123", "password1"}
        };
    }
}
