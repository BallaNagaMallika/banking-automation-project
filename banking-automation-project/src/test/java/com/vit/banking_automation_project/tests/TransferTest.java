package com.vit.banking_automation_project.tests;

import com.vit.banking_automation_project.base.BaseClass;
import com.vit.banking_automation_project.pages.HomePage;
import com.vit.banking_automation_project.pages.TransferPage;
import com.vit.banking_automation_project.utils.DateUtil;
import com.vit.banking_automation_project.utils.ExcelUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTest extends BaseClass {

    private static final Logger log = Logger.getLogger(TransferTest.class);

    @Test(priority = 1)
    public void validateFundTransfer() {

        String loginExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/LoginCredentials.xlsx";

        String transferExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/TransferData.xlsx";

        ExcelUtil loginExcel = new ExcelUtil(loginExcelPath, "LoginCredentials");
        ExcelUtil transferExcel = new ExcelUtil(transferExcelPath, "TransferData");

        try {
            int loginRow = loginExcel.getFirstDataRowIndex();
            int transferRow = transferExcel.getFirstDataRowIndex();

            String username = loginExcel.getCellData(loginRow, "username");
            String password = loginExcel.getCellData(loginRow, "password");
            String amount = transferExcel.getCellData(transferRow, "amount");
            String descriptionPrefix = transferExcel.getCellData(transferRow, "descriptionPrefix");

            String transferDescription =
                    DateUtil.generateTransferDescription(descriptionPrefix);

            HomePage homePage = new HomePage(driver);
            TransferPage transferPage = new TransferPage(driver);

            log.info("Logging into application with username: " + username);
            homePage.login(username, password);

            Assert.assertTrue(
                    homePage.isLoginSuccessful(),
                    "Login failed. Error: " + homePage.getLoginErrorMessage()
            );

            log.info("Starting fund transfer with amount: " + amount);
            log.info("Transfer description: " + transferDescription);

            transferPage.clickTransferFunds();
            transferPage.enterAmount(amount);
            transferPage.selectFromAccountByIndex(0);
            transferPage.selectToAccountByIndex(0);
            transferPage.clickTransferButton();

            Assert.assertTrue(
                    transferPage.isTransferSuccessMessageDisplayed(),
                    "Transfer success message is not displayed"
            );

            Assert.assertTrue(
                    driver.getPageSource().contains(amount),
                    "Transfer amount is not displayed correctly after transfer"
            );

            log.info("Fund transfer completed successfully");

        } finally {
            loginExcel.closeWorkbook();
            transferExcel.closeWorkbook();
            log.info("Excel workbooks closed successfully");
        }
    }

    @Test(priority = 2)
    public void validateInvalidTransferAmount() {

        String loginExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/LoginCredentials.xlsx";

        String transferExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/TransferData.xlsx";

        ExcelUtil loginExcel = new ExcelUtil(loginExcelPath, "LoginCredentials");
        ExcelUtil transferExcel = new ExcelUtil(transferExcelPath, "TransferData");

        try {
            int loginRow = loginExcel.getFirstDataRowIndex();

            String username = loginExcel.getCellData(loginRow, "username");
            String password = loginExcel.getCellData(loginRow, "password");

            int invalidTransferRow = transferExcel.getFirstDataRowIndex() + 2;

            String invalidAmount =
                    transferExcel.getCellData(invalidTransferRow, "amount");

            HomePage homePage = new HomePage(driver);
            TransferPage transferPage = new TransferPage(driver);

            log.info("Logging into application with username: " + username);
            homePage.login(username, password);

            Assert.assertTrue(
                    homePage.isLoginSuccessful(),
                    "Login failed. Error: " + homePage.getLoginErrorMessage()
            );

            log.info("Starting invalid fund transfer with amount: " + invalidAmount);

            transferPage.clickTransferFunds();
            transferPage.enterAmount(invalidAmount);
            transferPage.selectFromAccountByIndex(0);
            transferPage.selectToAccountByIndex(0);
            transferPage.clickTransferButton();

            Assert.assertTrue(
                    driver.getPageSource().contains("error")
                            || driver.getPageSource().contains("Error")
                            || driver.getPageSource().contains("Invalid")
                            || driver.getPageSource().contains("amount")
                            || driver.getPageSource().contains("Amount"),
                    "Invalid transfer error is not handled properly"
            );

            log.info("Invalid transfer amount validation completed");

        } finally {
            loginExcel.closeWorkbook();
            transferExcel.closeWorkbook();
            log.info("Excel workbooks closed successfully");
        }
    }
}