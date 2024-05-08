<<<<<<< HEAD
package com.CAPP.CappBE.S1X_PLUS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PetstoreSearchTest {
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
    public void testSearchByProductTitle() {
        navigateToWebsite("https://petstore.com/collections/dog");
        searchByProductTitle("Collar"); // Change this to the product title you want to search for
        assertTrue(verifySearchResults("Collar")); // Change this to the expected product title
    }

    private void navigateToWebsite(String websiteUrl) {
        driver.get(websiteUrl);
    }

    private void searchByProductTitle(String title) {
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-search-header")));
        searchIcon.click();
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchInput.sendKeys(title);
        searchInput.sendKeys(Keys.ENTER);
    }

    private boolean verifySearchResults(String expectedTitle) {
        WebElement searchResultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-title")));
        String actualTitle = searchResultTitle.getText();
        return actualTitle.contains(expectedTitle);
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PetstoreSearchTest {
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
    public void testSearchByProductTitle() {
        navigateToWebsite("https://petstore.com/collections/dog");
        searchByProductTitle("Collar"); // Change this to the product title you want to search for
        assertTrue(verifySearchResults("Collar")); // Change this to the expected product title
    }

    private void navigateToWebsite(String websiteUrl) {
        driver.get(websiteUrl);
    }

    private void searchByProductTitle(String title) {
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-search-header")));
        searchIcon.click();
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchInput.sendKeys(title);
        searchInput.sendKeys(Keys.ENTER);
    }

    private boolean verifySearchResults(String expectedTitle) {
        WebElement searchResultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-title")));
        String actualTitle = searchResultTitle.getText();
        return actualTitle.contains(expectedTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

>>>>>>> 178be0722890a75cf56ba664611bca2010f1f8b4
