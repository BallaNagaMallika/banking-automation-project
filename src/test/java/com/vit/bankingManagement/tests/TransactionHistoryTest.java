package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.AccountsOverviewPage;
import com.vit.bankingManagement.pages.HomePage;
import com.vit.bankingManagement.pages.TransactionHistoryPage;
import com.vit.bankingManagement.utils.ConfigReader;

public class TransactionHistoryTest extends BaseTest {

    @Test(priority = 7)
    public void verifyTransactionHistory() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        loginWithRuntimeUser();

        HomePage homePage =
                new HomePage(driver);

        homePage.clickAccountsOverview();

        AccountsOverviewPage accountsOverviewPage =
                new AccountsOverviewPage(driver);

        accountsOverviewPage.clickFirstAccount();

        TransactionHistoryPage transactionHistoryPage =
                new TransactionHistoryPage(driver);

        Assert.assertTrue(
                transactionHistoryPage.isTransactionTableDisplayed());

    }

}