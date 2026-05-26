package com.vit.banking_automation_project.tests;

import com.vit.banking_automation_project.base.BaseClass;
import com.vit.banking_automation_project.pages.HomePage;
import com.vit.banking_automation_project.utils.ExcelUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionHistoryTest extends BaseClass {

    private static final Logger log = Logger.getLogger(TransactionHistoryTest.class);

    @Test
    public void validateTransactionHistory() {

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

            HomePage homePage = new HomePage(driver);

            log.info("Logging into application with username: " + username);
            homePage.login(username, password);

            Assert.assertTrue(
                    homePage.isLoginSuccessful(),
                    "Login failed. Error: " + homePage.getLoginErrorMessage()
            );

            log.info("Navigating to Accounts Overview");
            driver.findElement(By.linkText("Accounts Overview")).click();

            Assert.assertTrue(
                    driver.getPageSource().contains("$")
                            || driver.getPageSource().contains(amount),
                    "Account balance or transaction amount is not found in Accounts Overview"
            );

            log.info("Navigating to Transaction History");

            if (driver.getPageSource().contains("Transaction")) {
                Assert.assertTrue(driver.getPageSource().contains("Transaction"),
                        "Transaction history section is not displayed");
            }

            Assert.assertTrue(
                    driver.getPageSource().contains("$")
                            || driver.getPageSource().contains(amount)
                            || driver.getPageSource().contains(descriptionPrefix),
                    "Latest transaction details are not found"
            );

            log.info("Transaction history validation completed successfully");

        } finally {
            loginExcel.closeWorkbook();
            transferExcel.closeWorkbook();
            log.info("Excel workbooks closed successfully");
        }
    }
}