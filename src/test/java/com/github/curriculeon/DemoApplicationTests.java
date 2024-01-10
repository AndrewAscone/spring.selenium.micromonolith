package com.github.curriculeon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class DemoApplicationTests {

    @Test
    public void test() {
        // Use WebDriverManager to manage FireFoxDriver
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

            // Find the name field for signup, click into it, and assign it to a variable
            driver.findElement(By.cssSelector("input[data-qa*='signup-name']")).click();
            WebElement signupName = driver.findElement(By.cssSelector("input[data-qa*='signup-name']"));

            // Generate a random name and pass it into the name field
            String testName = RandomStringUtils.randomAlphabetic(10);
            signupName.sendKeys(testName);

            // Find the email address field for signup, click into it, and assign it to a variable
            driver.findElement(By.cssSelector("input[data-qa*='signup-email']")).click();
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

            // Click radio button under "Title" for gender
            driver.findElement(By.cssSelector("input[id*='id_gender1']")).click();

            // Find the password field, click into it, and assign it to a variable
            driver.findElement(By.cssSelector("input[id*='password']")).click();
            WebElement signupPass = driver.findElement(By.cssSelector("input[id*='password']"));

            // Generate random string and pass it to the password field
            String testSignupPass = RandomStringUtils.randomAlphanumeric(10);
            signupPass.sendKeys(testSignupPass);

            // Find date of birth select menus and interact with them
            driver.findElement(By.cssSelector("select[id*='days']")).click();
            WebElement signupBirthdateDay = driver.findElement(By.cssSelector("select[id*='days']"));
            signupBirthdateDay.sendKeys("5");

            driver.findElement(By.cssSelector("select[id*='months']")).click();
            WebElement signupBirthdateMonth = driver.findElement(By.cssSelector("select[id*='months']"));
            signupBirthdateMonth.sendKeys("November");

            driver.findElement(By.cssSelector("select[id*='years']")).click();
            WebElement signupBirthdateYear = driver.findElement(By.cssSelector("select[id*='years']"));
            signupBirthdateYear.sendKeys("1989");

            // Click checkboxes for newsletter/offers
            driver.findElement(By.cssSelector("input[id*='newsletter']")).click();
            driver.findElement(By.cssSelector("input[id*='optin']")).click();

            // Find first name field under Address Information and set to a variable
            WebElement addressFirstName = driver.findElement(By.cssSelector("input[data-qa*='first_name']"));

            // Generate random name and pass it to first name field
            String testAddressFirstName = RandomStringUtils.randomAlphabetic(8);
            addressFirstName.sendKeys(testAddressFirstName);

            // Find last name field under Address Information and set to a variable
            WebElement addressLastName = driver.findElement(By.cssSelector("input[data-qa*='last_name']"));

            // Generate random name and pass it to last name field
            String testAddressLastName = RandomStringUtils.randomAlphabetic(8);
            addressLastName.sendKeys(testAddressLastName);

            // Find company field under Address Information and set to a variable
            WebElement addressCompanyName = driver.findElement(By.cssSelector("input[data-qa*='company']"));

            // Generate random text and pass it to company field
            String testCompanyName = RandomStringUtils.randomAlphanumeric(12);
            addressCompanyName.sendKeys(testCompanyName);

            // Find first address line under Address Information, set to variable
            WebElement addressFirstAddressLine = driver.findElement(By.cssSelector("input[data-qa*='address']"));

            // Generate random text styled as an address, pass to first address line
            String testAddressFirstAddressLine = RandomStringUtils.randomNumeric(3) + " " +
                                        RandomStringUtils.randomAlphabetic(10) + " Street";
            addressFirstAddressLine.sendKeys(testAddressFirstAddressLine);

            // Find second address line under Address Information, set to variable
            WebElement addressSecondAddressLine = driver.findElement(By.cssSelector("input[data-qa*='address2']"));

            // Generate random text styled as an address, pass to second address line
            String testAddressSecondAddressLine = "P.O. Box " + RandomStringUtils.randomNumeric(3)
                                                    + ", " + testCompanyName;
            addressSecondAddressLine.sendKeys(testAddressSecondAddressLine);

            // Find country selector under Address Information, set it to United States
            WebElement addressCountry = driver.findElement(By.cssSelector("select[data-qa*='country']"));
            addressCountry.sendKeys("United States");

            // Find state field under Address Information, set to variable
            WebElement addressState = driver.findElement(By.cssSelector("input[data-qa*='state']"));

            // Generate random text and pass it to state field
            String testAddressState = RandomStringUtils.randomAlphabetic(6);
            addressState.sendKeys(testAddressState);

            // Find city field under Address Information, set to variable
            WebElement addressCity = driver.findElement(By.cssSelector("input[data-qa*='city']"));

            // Generate random text and pass it to the city field
            String testAddressCity = RandomStringUtils.randomAlphabetic(10);
            addressCity.sendKeys(testAddressCity);

            // Find zipcode field under Address Information, set to variable
            WebElement addressZipcode = driver.findElement(By.cssSelector("input[data-qa*='zipcode']"));

            // Generate random numbers styled as 5 number zipcode, pass to zipcode field
            String testAddressZipcode = RandomStringUtils.randomNumeric(5);
            addressZipcode.sendKeys(testAddressZipcode);

            // Find mobile number field under Address Information, set to variable
            WebElement addressMobileNumber = driver.findElement(By.cssSelector("input[data-qa*='mobile_number']"));

            //Generate random numbers styled as phone number, pass to mobile number field
            String testAddressMobileNumber = "(" + RandomStringUtils.randomNumeric(3) + ") " +
                    RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4);
            addressMobileNumber.sendKeys(testAddressMobileNumber);

            // Find and click on the Create Account button
            WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-qa*='create-account']"));
            createAccountButton.sendKeys(Keys.ENTER);

            Thread.sleep(2000);

            // Test for navigation to account created page
            String actual_url4 = driver.getCurrentUrl();
            String expected4 = "https://automationexercise.com/account_created";
            Assert.assertEquals(expected4, actual_url4);

            // Find and click continue button on account created page
            driver.findElement(By.cssSelector("a[data-qa*='continue-button']")).click();

//            Thread.sleep(1000);
//
//            // Test for navigation to ad popup before reaching home page
//            String actual_url5 = driver.getCurrentUrl();
//            String expected5 = "https://automationexercise.com/account_created#google_vignette";
//            Assert.assertEquals(expected5, actual_url5);
//
//            // Find and click the close button on the ad popup
//            driver.findElement(By.cssSelector("div[id*='dismiss-button']")).click();

            Thread.sleep(2000);

            // Test for navigation back to home page
            String actual_url6 = driver.getCurrentUrl();
            String expected6 = "https://automationexercise.com/";
            Assert.assertEquals(expected6, actual_url6);

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
