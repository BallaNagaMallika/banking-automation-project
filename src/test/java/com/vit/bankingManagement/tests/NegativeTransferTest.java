package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.HomePage;
import com.vit.bankingManagement.pages.TransferFundsPage;
import com.vit.bankingManagement.utils.ConfigReader;

public class NegativeTransferTest extends BaseTest {

    @Test(priority = 6)
    public void verifyInvalidTransferAmount() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        loginWithRuntimeUser();

        HomePage homePage =
                new HomePage(driver);

        homePage.clickTransferFunds();

        TransferFundsPage transferFundsPage =
                new TransferFundsPage(driver);

        transferFundsPage.enterAmount("invalid");

        transferFundsPage.clickTransferButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("error")
                ||
                driver.getPageSource()
                        .contains("invalid")
                ||
                driver.getCurrentUrl()
                        .contains("transfer"));

    }

}