package org.hexavarsity.basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumBasics {

    static WebDriver driver;
    static WebDriverWait wdw;

    public static void main(String[] args) throws Exception {

        try {
            driver = new ChromeDriver();
            wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

            driver.get("http://www.google.com");

        } catch (WebDriverException wde) {
            throw new Exception(wde.getMessage());
        }

        // Common driver actions
        System.out.printf("Current URL: %s\n", driver.getCurrentUrl());
        System.out.printf("Page source: %s\n", driver.getPageSource());
        System.out.printf("Get Page title: %s", driver.getTitle());

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Hexaware", Keys.ENTER);

        WebElement link = driver.findElement(By.partialLinkText("Hexaware Technologies | "));
        wdw.until(ExpectedConditions.visibilityOf(link)).click();

        assertEquals("https://hexaware.com", driver.getCurrentUrl());

        driver.quit();

    }

}
