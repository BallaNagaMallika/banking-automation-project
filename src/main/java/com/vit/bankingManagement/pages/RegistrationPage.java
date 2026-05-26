package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class RegistrationPage {

    private final WebDriver driver;

    private final By registerLink =
            By.linkText("Register");

    private final By firstNameTextBox =
            By.cssSelector("input[id='customer.firstName']");

    private final By lastNameTextBox =
            By.cssSelector("input[id='customer.lastName']");

    private final By addressTextBox =
            By.cssSelector("input[id='customer.address.street']");

    private final By cityTextBox =
            By.cssSelector("input[id='customer.address.city']");

    private final By stateTextBox =
            By.cssSelector("input[id='customer.address.state']");

    private final By zipCodeTextBox =
            By.cssSelector("input[id='customer.address.zipCode']");

    private final By phoneTextBox =
            By.cssSelector("input[id='customer.phoneNumber']");

    private final By ssnTextBox =
            By.cssSelector("input[id='customer.ssn']");

    private final By usernameTextBox =
            By.cssSelector("input[id='customer.username']");

    private final By passwordTextBox =
            By.cssSelector("input[id='customer.password']");

    private final By confirmPasswordTextBox =
            By.cssSelector("input[id='repeatedPassword']");

    private final By registerButton =
            By.cssSelector("input[value='Register']");

    private final By successMessage =
            By.cssSelector("div#rightPanel p");

    private final By welcomeMessage =
            By.xpath("//h1[contains(text(),'Welcome')]");
    private final By firstNameError =
            By.id("customer.firstName.errors");

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;

    }

    public void clickRegisterLink() {

        WaitUtils.waitForClickable(driver, registerLink)
                .click();

    }

    public void enterFirstName(String firstName) {

        WaitUtils.waitForVisibility(driver, firstNameTextBox)
                .sendKeys(firstName);

    }

    public void enterLastName(String lastName) {

        WaitUtils.waitForVisibility(driver, lastNameTextBox)
                .sendKeys(lastName);

    }

    public void enterAddress(String address) {

        WaitUtils.waitForVisibility(driver, addressTextBox)
                .sendKeys(address);

    }

    public void enterCity(String city) {

        WaitUtils.waitForVisibility(driver, cityTextBox)
                .sendKeys(city);

    }

    public void enterState(String state) {

        WaitUtils.waitForVisibility(driver, stateTextBox)
                .sendKeys(state);

    }

    public void enterZipCode(String zipCode) {

        WaitUtils.waitForVisibility(driver, zipCodeTextBox)
                .sendKeys(zipCode);

    }

    public void enterPhone(String phone) {

        WaitUtils.waitForVisibility(driver, phoneTextBox)
                .sendKeys(phone);

    }

    public void enterSSN(String ssn) {

        WaitUtils.waitForVisibility(driver, ssnTextBox)
                .sendKeys(ssn);

    }

    public void enterUsername(String username) {

        WaitUtils.waitForVisibility(driver, usernameTextBox)
                .sendKeys(username);

    }

    public void enterPassword(String password) {

        WaitUtils.waitForVisibility(driver, passwordTextBox)
                .sendKeys(password);

    }

    public void enterConfirmPassword(String password) {

        WaitUtils.waitForVisibility(driver, confirmPasswordTextBox)
                .sendKeys(password);

    }

    public void clickRegisterButton() {

        WaitUtils.waitForClickable(driver, registerButton)
                .click();

    }

    public String getSuccessMessage() {

        return WaitUtils.waitForVisibility(driver, successMessage)
                .getText();

    }

    public String getWelcomeMessage() {

        return WaitUtils.waitForVisibility(driver, welcomeMessage)
                .getText();

    }
    public String getFirstNameError() {

        return WaitUtils.waitForVisibility(
                driver,
                firstNameError)
                .getText();

    }

}