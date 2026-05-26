package com.vit.banking_automation_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.banking_automation_project.utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    private final By registerLink = By.linkText("Register");
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By logoutLink = By.linkText("Log Out");
    private final By loginError = By.cssSelector(".error");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister() {
        WaitUtils.visible(registerLink).click();
    }

    public void login(String user, String pass) {
        WaitUtils.visible(username).clear();
        WaitUtils.visible(username).sendKeys(user);

        WaitUtils.visible(password).clear();
        WaitUtils.visible(password).sendKeys(pass);

        WaitUtils.visible(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        try {
            return WaitUtils.visible(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoginErrorMessage() {
        try {
            return WaitUtils.visible(loginError).getText();
        } catch (Exception e) {
            return "No login error message displayed";
        }
    }
}