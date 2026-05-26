package com.vit.bankingManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.utils.WaitUtils;

public class TransactionHistoryPage {

    private final WebDriver driver;

    private final By transactionTable =
            By.cssSelector("table#transactionTable");

    private final String transactionAmountXpath =
            "//table//td[contains(text(),'%s')]";

    public TransactionHistoryPage(WebDriver driver) {

        this.driver = driver;

    }

    public boolean isTransactionTableDisplayed() {

        return WaitUtils.waitForVisibility(
                driver,
                transactionTable)
                .isDisplayed();

    }

    public boolean isTransactionAvailable(String amount) {

        return WaitUtils.waitForVisibility(
                driver,
                WaitUtils.getDynamicXpath(
                        transactionAmountXpath,
                        amount))
                .isDisplayed();

    }

}