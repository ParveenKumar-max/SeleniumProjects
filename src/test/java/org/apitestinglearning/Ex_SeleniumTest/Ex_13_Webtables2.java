package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ex_13_Webtables2 {

    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify WebTables")
    public void testWebtablesSelenium() {


        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.iana.org/domains/reserved");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//table[@class='iana-table']")));

        //  driver.findElement(By.xpath("//table[@class='iana-table']"));
        // Get all rows (except header)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='iana-table']"));

        // Find first table item and Match.

            String name = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();

            if (name.equalsIgnoreCase("Arabic")) ;
            {  // Search By Name

                System.out.println("First Name is " + name + "  matching");
            }
            for (int i = 0;  i < rows.size(); i++) {
            List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
            for (WebElement c : col) {
                System.out.println(c.getText() + " | ");
            }
        }
        driver.quit();
    }
}
