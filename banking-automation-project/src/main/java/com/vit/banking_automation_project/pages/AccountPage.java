package com.vit.banking_automation_project.pages;

import com.vit.banking_automation_project.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    private final By openNewAccountLink = By.linkText("Open New Account");
    private final By accountTypeDropdown = By.id("type");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By openAccountButton = By.xpath("//input[@value='Open New Account']");
    private final By newAccountId = By.id("newAccountId");
    private final By accountsOverviewLink = By.linkText("Accounts Overview");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOpenNewAccount() {
        WaitUtils.clickElement(openNewAccountLink);
    }

    public void selectAccountType(String accountType) {
        WaitUtils.selectByVisibleText(accountTypeDropdown, accountType);
    }

    public void selectFromAccountByIndex(int index) {
        WaitUtils.selectByIndex(fromAccountDropdown, index);
    }

    public void clickOpenAccountButton() {
        WaitUtils.clickElement(openAccountButton);
    }

    public String getNewAccountNumber() {
        return WaitUtils.getText(newAccountId);
    }

    public void goToAccountsOverview() {
        WaitUtils.clickElement(accountsOverviewLink);
    }

    public boolean isNewAccountCreated() {
        return WaitUtils.visible(newAccountId).isDisplayed();
    }
}