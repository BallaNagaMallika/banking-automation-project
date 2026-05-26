package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameTextBox =
            By.cssSelector("input[name='username']");

    private final By passwordTextBox =
            By.cssSelector("input[name='password']");

    private final By loginButton =
            By.cssSelector("input[value='Log In']");

    private final By errorMessage =
            By.cssSelector("p.error");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    public void enterUsername(String username) {

        WaitUtils.waitForVisibility(driver, usernameTextBox)
                .sendKeys(username);

    }

    public void enterPassword(String password) {

        WaitUtils.waitForVisibility(driver, passwordTextBox)
                .sendKeys(password);

    }

    public void clickLogin() {

        WaitUtils.waitForClickable(driver, loginButton)
                .click();

    }

    public String getErrorMessage() {

        return WaitUtils.waitForVisibility(driver, errorMessage)
                .getText();

    }
    public void login(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

}