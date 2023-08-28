package org.hexavarsity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeltaTest {

    static WebDriver driver;
    static WebElement element;

    static WebDriverWait wait;

    public static void main(String[] args) throws Exception {

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        // implicit wait => apply this wait to all the elements in session

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.navigate().to("https://www.delta.com/");
        } catch (WebDriverException wde) {
            throw new Exception(wde.getMessage());
        }


        try {
            WebElement welcomeDialog = driver.findElement(By.xpath("//button[contains(text(),\" Mexico - English\")]"));
            if (welcomeDialog.isDisplayed()) {
                welcomeDialog.click();
            }

            // click on selectFrom id: fromAirportName

            element = driver.findElement(By.id("fromAirportName"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            // Select from id: search_input
            element = driver.findElement(By.id("search_input"));
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys("MTY");

            Thread.sleep(10000);
            element = driver.findElement(By.cssSelector(".search-result-container ul li:first-child"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();


            Thread.sleep(10000);

            driver.quit();
        } catch (Exception e) {
            driver.quit();
        }


    }

}
