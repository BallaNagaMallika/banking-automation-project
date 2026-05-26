package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class AccountsOverviewPage {

    private final WebDriver driver;

    private final By accountTable =
            By.cssSelector("table#accountTable");

    private final By firstAccount =
            By.cssSelector("table tbody tr td a");

    public AccountsOverviewPage(WebDriver driver) {

        this.driver = driver;

    }

    public boolean isAccountTableDisplayed() {

        return WaitUtils.waitForVisibility(driver, accountTable)
                .isDisplayed();

    }

    public void clickFirstAccount() {

        WaitUtils.waitForClickable(driver, firstAccount)
                .click();

    }

}