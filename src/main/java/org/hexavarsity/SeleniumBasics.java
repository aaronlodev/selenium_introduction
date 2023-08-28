package org.hexavarsity;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        try {
            driver = new ChromeDriver();

            driver.get("http://www.google.com");

        } catch (WebDriverException wde) {
            throw new Exception(wde.getMessage());
        }

        Thread.sleep(10000);

        // Common driver actions
        System.out.printf("Current URL: %s\n", driver.getCurrentUrl());
        System.out.printf("Page source: %s\n", driver.getPageSource());
        System.out.printf("Get Page title: %s", driver.getTitle());

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Hexaware", Keys.ENTER);


    }

}
