package org.apitestinglearning.Ex_SeleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ex_12_WebTables {


    @Test
    @Owner("Parveen Chaudhary")
    @Description("TC_12_Verify WebTables")
    public void testWebTablesSelenium(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/webtable"); // replace with your table URL

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean recordFound = false;

        // Loop through table pages
        while (true) {
            // Wait for table to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            // Get all rows (except header)
            List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

            for (int i = 1; i <= rows.size(); i++) {
                String name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();

                if (name.equalsIgnoreCase("Alice")) { // search by name
                    String age = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText();
                    System.out.println("Found: " + name + " | Age: " + age);

                    // Click a link/button in the same row (3rd column in this example)
                    WebElement actionBtn = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]//button"));
                    actionBtn.click();

                    recordFound = true;
                    break;
                }
            }

            if (recordFound) break;

            // Check if Next button is enabled for pagination
            List<WebElement> nextBtn = driver.findElements(By.xpath("//a[text()='Next' and not(@disabled)]"));

            if (nextBtn.size() > 0) {
                nextBtn.get(0).click();
                wait.until(ExpectedConditions.stalenessOf(rows.get(0))); // Wait for page change
            } else {
                System.out.println("Record not found in any page");
                break;
            }
        }

        driver.quit();
    }
}

