<<<<<<< HEAD
package com.CAPP.CappBE.S1X_PLUS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PetStoreTests {
    public static void main(String[] args) {
        // Set the path to the geckodriver executable
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Test navigation to the login page
        navigateToLoginPage(driver);

        // Test negative login
        negativeLoginTest(driver);

        // Test navigation to the registration page
        navigateToRegistrationPage(driver);

        // Test positive registration
        positiveRegistrationTest(driver);

        // Test positive login
        positiveLoginTest(driver);

        // Test password recovery
        passwordRecoveryTest(driver);

        // Test cart open and close
        testCartOpenAndClose(driver);

        // Test logout
        logout(driver);

        // Close the browser
        driver.quit();
    }

    public static void navigateToLoginPage(WebDriver driver) {
        // Open the website
        driver.get("https://petstore.com/");

        // Find and click the user icon to navigate to the login page
        WebElement userIcon = driver.findElement(By.cssSelector(".icon-user"));
        userIcon.click();

        // Verify if login page is loaded (optional)
        // For example, you can check for an element present on the login page
    }

    public static void positiveLoginTest(WebDriver driver) {
        // Find the email input field and enter the email
        WebElement emailInput = driver.findElement(By.id("CustomerEmail"));
        emailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find the password input field and enter the password
        WebElement passwordInput = driver.findElement(By.id("CustomerPassword"));
        passwordInput.sendKeys("akhil123");

        // Find and click the login button using CSS selector
        WebElement loginButton = driver.findElement(By.cssSelector(".btn--full"));
        loginButton.click();

        // Verify if login was successful (optional)
        // For example, you can check if the user is redirected to the home page after login
    }

    public static void negativeLoginTest(WebDriver driver) {
        // Find the email input field and enter an invalid email
        WebElement emailInput = driver.findElement(By.id("CustomerEmail"));
        emailInput.sendKeys("invalid_email@example.com");

        // Find the password input field and enter an invalid password
        WebElement passwordInput = driver.findElement(By.id("CustomerPassword"));
        passwordInput.sendKeys("invalid_password");

        // Find and click the login button using CSS selector
        WebElement loginButton = driver.findElement(By.cssSelector(".btn--full"));
        loginButton.click();

        // Verify if login failed (optional)
        // For example, you can check if an error message is displayed indicating invalid credentials
    }

    public static void navigateToRegistrationPage(WebDriver driver) {
        // Find and click the registration link
        WebElement registerLink = driver.findElement(By.id("customer_register_link"));
        registerLink.click();

        // Verify if registration page is loaded (optional)
        // For example, you can check for an element present on the registration page
    }

    public static void positiveRegistrationTest(WebDriver driver) {
        // Find the First Name input field and enter data
        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Akhil");

        // Find the Last Name input field and enter data
        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("suresh");

        // Find the Email input field and enter data
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find the Create Password input field and enter data
        WebElement passwordInput = driver.findElement(By.id("CreatePassword"));
        passwordInput.sendKeys("akhil123");

        // Find and click the registration button using CSS selector
        WebElement registerButton = driver.findElement(By.cssSelector(".btn--full"));
        registerButton.click();

        // Verify if registration was successful (optional)
        // For example, you can check if the user is redirected to the home page after registration
    }

    public static void passwordRecoveryTest(WebDriver driver) {
        // Find and click on the password recovery link
        WebElement recoverPasswordLink = driver.findElement(By.id("RecoverPassword"));
        recoverPasswordLink.click();

        // Find the email input field for password recovery and enter the email
        WebElement recoverEmailInput = driver.findElement(By.id("RecoverEmail"));
        recoverEmailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find and click on the button to send recovery mail using CSS selector
        WebElement sendRecoveryButton = driver.findElement(By.cssSelector("p:nth-child(5) > .btn"));
        sendRecoveryButton.click();

        // Optionally, you might want to wait for the recovery mail to be sent
        // For example, you can wait for a success message or an element indicating the mail was sent
    }

    public static void logout(WebDriver driver) {
        // Find and click the logout button
        WebElement logoutButton = driver.findElement(By.cssSelector(".btn--secondary"));
        logoutButton.click();

        // Optionally, you might want to wait for the logout process to complete
        // For example, wait for a specific element on the login page to appear
    }

    public static void testCartOpenAndClose(WebDriver driver) {
        // Find and click the cart icon to open the cart
        WebElement openCartButton = driver.findElement(By.cssSelector(".icon-cart"));
        openCartButton.click();

        // Wait for a short while to allow the cart to open (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and click the close button in the cart to close it
        WebElement closeCartButton = driver.findElement(By.cssSelector("#CartDrawer .icon"));
        closeCartButton.click();

        // Optionally, you might want to wait for the cart to close
        // For example, wait for a specific element indicating that the cart is closed
    }
=======
package com.CAPP.CappBE.S1X_PLUS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PetStoreTests {
    public static void main(String[] args) {
        // Set the path to the geckodriver executable
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Test navigation to the login page
        navigateToLoginPage(driver);

        // Test negative login
        negativeLoginTest(driver);

        // Test navigation to the registration page
        navigateToRegistrationPage(driver);

        // Test positive registration
        positiveRegistrationTest(driver);

        // Test positive login
        positiveLoginTest(driver);

        // Test password recovery
        passwordRecoveryTest(driver);

        // Test cart open and close
        testCartOpenAndClose(driver);

        // Test logout
        logout(driver);

        // Close the browser
        driver.quit();
    }

    public static void navigateToLoginPage(WebDriver driver) {
        // Open the website
        driver.get("https://petstore.com/");

        // Find and click the user icon to navigate to the login page
        WebElement userIcon = driver.findElement(By.cssSelector(".icon-user"));
        userIcon.click();

        // Verify if login page is loaded (optional)
        // For example, you can check for an element present on the login page
    }

    public static void positiveLoginTest(WebDriver driver) {
        // Find the email input field and enter the email
        WebElement emailInput = driver.findElement(By.id("CustomerEmail"));
        emailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find the password input field and enter the password
        WebElement passwordInput = driver.findElement(By.id("CustomerPassword"));
        passwordInput.sendKeys("akhil123");

        // Find and click the login button using CSS selector
        WebElement loginButton = driver.findElement(By.cssSelector(".btn--full"));
        loginButton.click();

        // Verify if login was successful (optional)
        // For example, you can check if the user is redirected to the home page after login
    }

    public static void negativeLoginTest(WebDriver driver) {
        // Find the email input field and enter an invalid email
        WebElement emailInput = driver.findElement(By.id("CustomerEmail"));
        emailInput.sendKeys("invalid_email@example.com");

        // Find the password input field and enter an invalid password
        WebElement passwordInput = driver.findElement(By.id("CustomerPassword"));
        passwordInput.sendKeys("invalid_password");

        // Find and click the login button using CSS selector
        WebElement loginButton = driver.findElement(By.cssSelector(".btn--full"));
        loginButton.click();

        // Verify if login failed (optional)
        // For example, you can check if an error message is displayed indicating invalid credentials
    }

    public static void navigateToRegistrationPage(WebDriver driver) {
        // Find and click the registration link
        WebElement registerLink = driver.findElement(By.id("customer_register_link"));
        registerLink.click();

        // Verify if registration page is loaded (optional)
        // For example, you can check for an element present on the registration page
    }

    public static void positiveRegistrationTest(WebDriver driver) {
        // Find the First Name input field and enter data
        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Akhil");

        // Find the Last Name input field and enter data
        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("suresh");

        // Find the Email input field and enter data
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find the Create Password input field and enter data
        WebElement passwordInput = driver.findElement(By.id("CreatePassword"));
        passwordInput.sendKeys("akhil123");

        // Find and click the registration button using CSS selector
        WebElement registerButton = driver.findElement(By.cssSelector(".btn--full"));
        registerButton.click();

        // Verify if registration was successful (optional)
        // For example, you can check if the user is redirected to the home page after registration
    }

    public static void passwordRecoveryTest(WebDriver driver) {
        // Find and click on the password recovery link
        WebElement recoverPasswordLink = driver.findElement(By.id("RecoverPassword"));
        recoverPasswordLink.click();

        // Find the email input field for password recovery and enter the email
        WebElement recoverEmailInput = driver.findElement(By.id("RecoverEmail"));
        recoverEmailInput.sendKeys("akhilsuresh550@gmail.com");

        // Find and click on the button to send recovery mail using CSS selector
        WebElement sendRecoveryButton = driver.findElement(By.cssSelector("p:nth-child(5) > .btn"));
        sendRecoveryButton.click();

        // Optionally, you might want to wait for the recovery mail to be sent
        // For example, you can wait for a success message or an element indicating the mail was sent
    }

    public static void logout(WebDriver driver) {
        // Find and click the logout button
        WebElement logoutButton = driver.findElement(By.cssSelector(".btn--secondary"));
        logoutButton.click();

        // Optionally, you might want to wait for the logout process to complete
        // For example, wait for a specific element on the login page to appear
    }

    public static void testCartOpenAndClose(WebDriver driver) {
        // Find and click the cart icon to open the cart
        WebElement openCartButton = driver.findElement(By.cssSelector(".icon-cart"));
        openCartButton.click();

        // Wait for a short while to allow the cart to open (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and click the close button in the cart to close it
        WebElement closeCartButton = driver.findElement(By.cssSelector("#CartDrawer .icon"));
        closeCartButton.click();

        // Optionally, you might want to wait for the cart to close
        // For example, wait for a specific element indicating that the cart is closed
    }
>>>>>>> 178be0722890a75cf56ba664611bca2010f1f8b4
}