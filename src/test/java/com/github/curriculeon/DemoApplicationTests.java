package com.github.curriculeon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoApplicationTests {

    @Test
    public void test() {
        // Use WebDriverManager to manage ChromeDriver
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        try {

            // Navigate to the web page
            driver.get("https://automationexercise.com/");

            // Test for navigation to main page
            String actual_url1 = driver.getCurrentUrl();
            String expected1 = "https://automationexercise.com/";
            Assert.assertEquals(expected1, actual_url1);

            // Find and click on the signup/login button
            driver.findElement(By.cssSelector("a[href*='/login']")).click();

            // Test checking driver has navigated to login/signup page
            String actual_url2 = driver.getCurrentUrl();
            String expected2 = "https://automationexercise.com/login";
            Assert.assertEquals(expected2, actual_url2);

            // Find the name field for signup and click into it
            driver.findElement(By.cssSelector("input[data-qa*='signup-name']")).click();

            // Set the name field for signup to a variable
            WebElement signupName = driver.findElement(By.cssSelector("input[data-qa*='signup-name']"));

            // Generate a random name and pass it into the name field
            String testName = RandomStringUtils.randomAlphabetic(10);
            signupName.sendKeys(testName);

            // Find the email address field for signup and click into it
            driver.findElement(By.cssSelector("input[data-qa*='signup-email']")).click();

            // Set the email address field for signup to a variable
            WebElement signupEmail = driver.findElement(By.cssSelector("input[data-qa*='signup-email']"));

            // Generate a random email address and pass it into the email field
            String testEmail = RandomStringUtils.randomAlphanumeric(10) + "@test.com";
            signupEmail.sendKeys(testEmail);

            // Click on the signup button after fields are filled
            driver.findElement(By.cssSelector("button[data-qa*='signup-button']")).click();

            // Test checking signup was successful
            String actual_url3 = driver.getCurrentUrl();
            String expected3 = "https://automationexercise.com/signup";
            Assert.assertEquals(expected3, actual_url3);


//            Thread.sleep(2000);
//
//            // Find and interact with the input fields
//            WebElement firstNameInput = driver.findElement(By.id("fname"));
//            WebElement lastNameInput = driver.findElement(By.id("lname"));
//
//            firstNameInput.sendKeys("John");
//            lastNameInput.sendKeys("Doe");
//
//            // Click the "Create Person" button
//            WebElement createButton = driver.findElement(By.xpath("//button[contains(text(), 'Create Person')]"));
//            createButton.click();
//
//            // Wait for the response to load (you may need to add explicit waits)
//            Thread.sleep(2000);
//
//            // Verify the output in the "output" div
//            WebElement outputDiv = driver.findElement(By.id("output"));
//            String outputText = outputDiv.getText();
//
//            if (outputText.contains("Successfully created")) {
//                System.out.println("Test passed: Person created successfully.");
//            } else {
//                System.out.println("Test failed: Person creation failed.");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            //driver.quit();
        }

    }
}
