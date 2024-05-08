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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetstoreUserCreationTest {
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
    public void testNonUniqueEmailErrorMessage() {
        navigateToWebsite("https://petstore.com/account/register");
        createUser("akhilsuresh550@gmail.com", "akhil", "Suresh", "akhil123");
        String errorMessage = getErrorMessage();
        assertEquals("Email already exists. Please use a different email.", errorMessage);
    }

    @Test
    public void testMissingMandatoryFieldsErrorMessage() {
        navigateToWebsite("https://petstore.com/account/register");
        createUser("", "akhil", "suresh", "akhil123");
        String errorMessage = getErrorMessage();
        assertEquals("Please fill in all mandatory fields.", errorMessage);
    }

    @Test
    public void testUserCreationAndRedirect() {
        navigateToWebsite("https://petstore.com/account/register");
        createUser("akhilsuresh550@gmail.com", "akhil", "Suresh", "akhil123");
        validateRedirectedPage();
        validateAccountInformation("akhilsuresh550@gmail.com", "akhil", "Suresh");
    }

    private void navigateToWebsite(String websiteUrl) {
        driver.get(websiteUrl);
    }

    private void createUser(String email, String firstName, String lastName, String password) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        WebElement passwordInput = driver.findElement(By.id("CreatePassword"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));


        emailInput.sendKeys(email);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    private String getErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")));
        return errorMessageElement.getText();
    }

    private void validateRedirectedPage() {
        // Assuming redirected page has a specific element to identify it
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-title")));
        assertEquals("My Account", pageTitle.getText());
    }

    private void validateAccountInformation(String expectedEmail, String expectedFirstName, String expectedLastName) {
        WebElement emailElement = driver.findElement(By.cssSelector(".account-email"));
        WebElement firstNameElement = driver.findElement(By.cssSelector(".account-first-name"));
        WebElement lastNameElement = driver.findElement(By.cssSelector(".account-last-name"));

        String actualEmail = emailElement.getText();
        String actualFirstName = firstNameElement.getText();
        String actualLastName = lastNameElement.getText();

        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedFirstName, actualFirstName);
        assertEquals(expectedLastName, actualLastName);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

