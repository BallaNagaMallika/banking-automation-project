package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class HomePage {

    private final WebDriver driver;

    private final By openAccountLink =
            By.linkText("Open New Account");

    private final By transferFundsLink =
            By.linkText("Transfer Funds");

    private final By accountsOverviewLink =
            By.linkText("Accounts Overview");

    private final By accountsOverviewTitle =
            By.xpath("//h1[text()='Accounts Overview']");
    
    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    public void clickOpenAccount() {

        WaitUtils.waitForClickable(driver, openAccountLink)
                .click();

    }

    public void clickTransferFunds() {

        WaitUtils.waitForClickable(driver, transferFundsLink)
                .click();

    }

    public void clickAccountsOverview() {

        WaitUtils.waitForClickable(driver, accountsOverviewLink)
                .click();

    }
    

    public boolean isHomePageLoaded() {

        return WaitUtils.waitForVisibility(
                driver,
                accountsOverviewTitle)
                .isDisplayed();

    }

}