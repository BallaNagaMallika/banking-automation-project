package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.vit.bankingManagement.utils.WaitUtils;

public class OpenAccountPage {

    private final WebDriver driver;

    private final By accountTypeDropdown =
            By.cssSelector("select#type");

    private final By openAccountButton =
            By.cssSelector("input[value='Open New Account']");

    private final By accountNumber =
            By.cssSelector("a#newAccountId");

    private final By newAccountId =
            By.id("newAccountId");

    public OpenAccountPage(WebDriver driver) {

        this.driver = driver;

    }

    public void selectAccountType(String accountType) {

        Select select =
                new Select(
                        WaitUtils.waitForVisibility(
                                driver,
                                accountTypeDropdown));

        select.selectByVisibleText(accountType);

    }

    public void clickOpenAccountButton() {

        WaitUtils.waitForClickable(driver, openAccountButton)
                .click();

    }

    public String getAccountNumber() {

        return WaitUtils.waitForVisibility(driver, accountNumber)
                .getText();

    }

    public boolean isAccountOpened() {

        return WaitUtils.waitForVisibility(
                driver,
                newAccountId)
                .isDisplayed();

    }

}