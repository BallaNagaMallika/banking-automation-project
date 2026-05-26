package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.HomePage;
import com.vit.bankingManagement.pages.TransferFundsPage;
import com.vit.bankingManagement.utils.ConfigReader;
import com.vit.bankingManagement.utils.ExcelReader;

public class TransferFundsTest extends BaseTest {

    @Test(priority = 5)
    public void verifyFundTransfer() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        loginWithRuntimeUser();

        HomePage homePage =
                new HomePage(driver);

        homePage.clickTransferFunds();

        TransferFundsPage transferFundsPage =
                new TransferFundsPage(driver);

        transferFundsPage.enterAmount(
                ExcelReader.getCellData(
                        "TransferData",
                        1,
                        0));

        transferFundsPage.clickTransferButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Transfer Complete"));

    }

}