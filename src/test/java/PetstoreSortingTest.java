<<<<<<< HEAD
package com.CAPP.CappBE.S1X_PLUS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PetstoreSortingTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Set the path to your geckodriver executable for Firefox
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSortingFromLowestPrice() {
        navigateToWebsite("https://petstore.com/collections/dog");
        sortByLowestPrice();
        assertTrue(verifySortingOrder(true));
    }

    @Test
    public void testSortingFromHighestPrice() {
        navigateToWebsite("https://petstore.com/collections/dog");
        sortByHighestPrice();
        assertTrue(verifySortingOrder(false));
    }

    private void navigateToWebsite(String websiteUrl) {
        driver.get(websiteUrl);
    }

    private void sortByLowestPrice() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("SortBy")));
        sortByDropdown.click();
        WebElement priceLowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SortBy option[value='Price, low to high']")));
        priceLowToHighOption.click();
    }

    private void sortByHighestPrice() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("SortBy")));
        sortByDropdown.click();
        WebElement priceHighToLowOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SortBy option[value='Price, high to low']")));
        priceHighToLowOption.click();
    }

    private boolean verifySortingOrder(boolean ascending) {
        boolean sorted = true;
        java.util.List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-price")); // Assuming product prices are displayed with class 'product-price'
        double prevPrice = Double.parseDouble(priceElements.get(0).getText().replaceAll("[^\\d.]", ""));

        for (WebElement priceElement : priceElements) {
            double currentPrice = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
            if (ascending && currentPrice < prevPrice) {
                sorted = false;
                break;
            } else if (!ascending && currentPrice > prevPrice) {
                sorted = false;
                break;
            }
            prevPrice = currentPrice;
        }

        return sorted;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
=======
package com.CAPP.CappBE.S1X_PLUS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PetstoreSortingTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Set the path to your geckodriver executable for Firefox
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSortingFromLowestPrice() {
        navigateToWebsite("https://petstore.com/collections/dog");
        sortByLowestPrice();
        assertTrue(verifySortingOrder(true));
    }

    @Test
    public void testSortingFromHighestPrice() {
        navigateToWebsite("https://petstore.com/collections/dog");
        sortByHighestPrice();
        assertTrue(verifySortingOrder(false));
    }

    private void navigateToWebsite(String websiteUrl) {
        driver.get(websiteUrl);
    }

    private void sortByLowestPrice() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("SortBy")));
        sortByDropdown.click();
        WebElement priceLowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SortBy option[value='Price, low to high']")));
        priceLowToHighOption.click();
    }

    private void sortByHighestPrice() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("SortBy")));
        sortByDropdown.click();
        WebElement priceHighToLowOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SortBy option[value='Price, high to low']")));
        priceHighToLowOption.click();
    }

    private boolean verifySortingOrder(boolean ascending) {
        boolean sorted = true;
        java.util.List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-price")); // Assuming product prices are displayed with class 'product-price'
        double prevPrice = Double.parseDouble(priceElements.get(0).getText().replaceAll("[^\\d.]", ""));

        for (WebElement priceElement : priceElements) {
            double currentPrice = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
            if (ascending && currentPrice < prevPrice) {
                sorted = false;
                break;
            } else if (!ascending && currentPrice > prevPrice) {
                sorted = false;
                break;
            }
            prevPrice = currentPrice;
        }

        return sorted;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
>>>>>>> 178be0722890a75cf56ba664611bca2010f1f8b4
