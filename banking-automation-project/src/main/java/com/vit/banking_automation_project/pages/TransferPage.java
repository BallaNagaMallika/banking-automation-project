package com.vit.banking_automation_project.pages;

import com.vit.banking_automation_project.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {

    WebDriver driver;

    private final By transferFundsLink = By.linkText("Transfer Funds");
    private final By amountField = By.id("amount");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By toAccountDropdown = By.id("toAccountId");
    private final By transferButton = By.xpath("//input[@value='Transfer']");
    private final By transferCompleteMessage = By.xpath("//h1[contains(text(),'Transfer Complete')]");
    private final By errorMessage = By.cssSelector(".error");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTransferFunds() {
        WaitUtils.clickElement(transferFundsLink);
        WaitUtils.waitForDropdownOptions(fromAccountDropdown);
        WaitUtils.waitForDropdownOptions(toAccountDropdown);
    }

    public void enterAmount(String amount) {
        WaitUtils.enterText(amountField, amount);
    }

    public void selectFromAccountByIndex(int index) {
        WaitUtils.waitForDropdownOptions(fromAccountDropdown);
        WaitUtils.selectByIndex(fromAccountDropdown, index);
    }

    public void selectToAccountByIndex(int index) {
        WaitUtils.waitForDropdownOptions(toAccountDropdown);
        WaitUtils.selectByIndex(toAccountDropdown, index);
    }

    public void clickTransferButton() {
        WaitUtils.clickElement(transferButton);
    }

    public boolean isTransferSuccessMessageDisplayed() {
        return WaitUtils.visible(transferCompleteMessage).isDisplayed();
    }

    public String getErrorMessage() {
        return WaitUtils.getText(errorMessage);
    }
}