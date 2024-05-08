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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetstoreCartTest {
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
    public void testAddingItemsToCartAndValidation() {
        navigateToProductPage("https://petstore.com/collections/dog");
        addItemToCart("Exercise Ball for Hamsters and Small Pets", "29.99");
        addItemToCart("Sturdy Basic Nylon Dog Collar with Quick Snap Buckle", "19.99");

        validateCartItemCount(2);
        validateCartTotalPrice("49.98");

        List<String> addedProductTitles = getAddedProductTitles();
        assertTrue(addedProductTitles.contains("Exercise Ball for Hamsters and Small Pets"));
        assertTrue(addedProductTitles.contains("Sturdy Basic Nylon Dog Collar with Quick Snap Buckle"));
    }

    private void navigateToProductPage(String productUrl) {
        driver.get(productUrl);
    }

    private void addItemToCart(String productName, String productPrice) {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ProductSelect-4660917174347")));
        addToCartButton.click();

        // Wait for cart to update
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".cart-item-count"), "1"));

        // Verify product details in cart
        WebElement cartProductTitle = driver.findElement(By.cssSelector(".ajaxcart__product-name"));
        WebElement cartProductPrice = driver.findElement(By.cssSelector(".ajaxcart__product-price"));

        assertEquals(productName, cartProductTitle.getText());
        assertEquals(productPrice, cartProductPrice.getText().replaceAll("[^\\d.]", ""));
    }

    private void validateCartItemCount(int expectedItemCount) {
        WebElement cartItemCount = driver.findElement(By.cssSelector(".cart-item-count"));
        int actualItemCount = Integer.parseInt(cartItemCount.getText());
        assertEquals(expectedItemCount, actualItemCount);
    }

    private void validateCartTotalPrice(String expectedTotalPrice) {
        WebElement cartTotalPrice = driver.findElement(By.cssSelector(".ajaxcart__price"));
        String actualTotalPrice = cartTotalPrice.getText().replaceAll("[^\\d.]", "");
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    private List<String> getAddedProductTitles() {
        List<WebElement> addedProductTitleElements = driver.findElements(By.cssSelector(".cart-product-title"));
        return addedProductTitleElements.stream().map(WebElement::getText).toList();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

