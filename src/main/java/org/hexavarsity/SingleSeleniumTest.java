package org.hexavarsity;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleSeleniumTest {

    static WebDriver driver;
    public static void main(String[] args) throws Exception {

        try {
            driver = new ChromeDriver();

            // Navigate to google.com website
            //driver.navigate().to("http://google.com");
            driver.get("http://www.google.com");

        }catch (WebDriverException wde){
            throw new Exception(wde.getMessage());
        }


        // googleSearchTest

        WebElement search = driver.findElement(By.id("APjFqb"));


        /* HTML Content */
        // get tagName from html element
        System.out.printf("TagName: %s\n", search.getTagName());

        // get text from html element
        System.out.printf("Text: %s\n", search.getText());

        // get css code
        System.out.printf("Location: %s", search.getLocation());


        /* HTML states  */
        // element is displayed?
        System.out.printf("Is element displayed? %s\n", search.isDisplayed());

        // element is enabled?
        System.out.printf("Is element enabled? %s\n", search.isEnabled());

        // element is selected?
        System.out.printf("Is element selected? %s\n", search.isSelected());


        /* Actions */

        // Type 'Hexaware'
        search.sendKeys("Hexaware", Keys.ENTER);

        Thread.sleep(5000);

        WebElement searchPageInput = driver.findElement(By.id("APjFqb"));

        // Clear
        System.out.printf("Element Text before clean: %s\n", searchPageInput.getText());
        searchPageInput.clear();
        System.out.printf("Element Text after clean: %s\n", searchPageInput.getText());


        // Refresh, go afterward and forward
        driver.navigate().refresh();
        Thread.sleep(3000);

        // go back
        driver.navigate().back();

        Thread.sleep(10000);

        // forward
        driver.navigate().forward();


        Thread.sleep(5000);
        System.out.println("Ending test case execution ------");

        // close the browser
        driver.quit();




    }

}
