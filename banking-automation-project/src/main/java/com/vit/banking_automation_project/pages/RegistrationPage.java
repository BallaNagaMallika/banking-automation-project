package com.vit.banking_automation_project.pages;

import com.vit.banking_automation_project.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegistrationPage {

    WebDriver driver;

    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By street = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phone = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");

    private final By usernameInput = By.id("customer.username");
    private final By passwordInput = By.id("customer.password");
    private final By confirmPassword = By.id("repeatedPassword");

    private final By registerButton = By.cssSelector("input[value='Register']");
    private final By welcomeTitle = By.className("title");
    private final By successMessage = By.cssSelector("#rightPanel p");
    private final By validationErrors = By.className("error");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerCustomer(Map<String, String> customer, String username, String password) {

        WaitUtils.enterText(firstName, customer.get("firstName"));
        WaitUtils.enterText(lastName, customer.get("lastName"));
        WaitUtils.enterText(street, customer.get("address"));
        WaitUtils.enterText(city, customer.get("city"));
        WaitUtils.enterText(state, customer.get("state"));
        WaitUtils.enterText(zipCode, customer.get("zipCode"));
        WaitUtils.enterText(phone, customer.get("phoneNumber"));
        WaitUtils.enterText(ssn, customer.get("ssn"));

        WaitUtils.enterText(usernameInput, username);
        WaitUtils.enterText(passwordInput, password);
        WaitUtils.enterText(confirmPassword, password);

        WaitUtils.clickElement(registerButton);
    }

    public void clickRegisterButton() {
        WaitUtils.clickElement(registerButton);
    }

    public String getWelcomeMessage() {
        return WaitUtils.getText(welcomeTitle);
    }

    public String getSuccessTitle() {
        return WaitUtils.getText(successMessage);
    }

    public List<String> getValidationErrors() {
        return WaitUtils.visibleElements(validationErrors)
                .stream()
                .map(element -> element.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public boolean isRegistrationFormDisplayed() {
        return WaitUtils.visible(firstName).isDisplayed();
    }
}