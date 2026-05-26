package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class TransferFundsPage {

    private final WebDriver driver;

    private final By amountTextBox =
            By.id("amount");

    private final By transferButton =
            By.cssSelector("input[value='Transfer']");

    private final By successMessage =
            By.cssSelector("div#showResult h1");
    
    private final By amountErrorMessage =
            By.cssSelector("p.error");

    private final By transferAmountInput =
            By.id("amount");

    public TransferFundsPage(WebDriver driver) {

        this.driver = driver;

    }
    public String getAmountErrorMessage() {

        return WaitUtils.waitForVisibility(
                driver,
                amountErrorMessage)
                .getText();

    }
    public void clearAmountField() {

        WaitUtils.waitForVisibility(
                driver,
                transferAmountInput)
                .clear();

    }

    public void enterAmount(String amount) {

        WaitUtils.waitForVisibility(driver, amountTextBox)
                .sendKeys(amount);

    }

    public void clickTransferButton() {

        WaitUtils.waitForClickable(driver, transferButton)
                .click();

    }

    public String getTransferSuccessMessage() {

        return WaitUtils.waitForVisibility(driver, successMessage)
                .getText();

    }

}