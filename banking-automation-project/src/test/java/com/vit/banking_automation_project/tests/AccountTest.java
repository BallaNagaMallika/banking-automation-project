package com.vit.banking_automation_project.tests;

import com.vit.banking_automation_project.base.BaseClass;
import com.vit.banking_automation_project.pages.AccountPage;
import com.vit.banking_automation_project.pages.HomePage;
import com.vit.banking_automation_project.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseClass {

    @Test
    public void validateOpenNewAccount() {

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
            String accountType = transferExcel.getCellData(transferRow, "fromAccountType");

            HomePage homePage = new HomePage(driver);
            AccountPage accountPage = new AccountPage(driver);

            logger.info("Logging into application with username: " + username);
            homePage.login(username, password);

            Assert.assertTrue(
                    homePage.isLoginSuccessful(),
                    "Login failed. Error: " + homePage.getLoginErrorMessage()
            );

            logger.info("Login successful");

            driver.navigate().to("https://parabank.parasoft.com/parabank/openaccount.htm");

            logger.info("Opening new account with type: " + accountType);

            accountPage.selectAccountType(accountType);

            accountPage.selectFromAccountByIndex(0);

            accountPage.clickOpenAccountButton();

            Assert.assertTrue(
                    accountPage.isNewAccountCreated(),
                    "Account creation confirmation is not displayed"
            );

            String accountNumber = accountPage.getNewAccountNumber();

            Assert.assertNotNull(accountNumber, "New account number is not generated");
            Assert.assertFalse(accountNumber.trim().isEmpty(), "New account number is empty");

            logger.info("New account created successfully. Account Number: " + accountNumber);

        } finally {
            loginExcel.closeWorkbook();
            transferExcel.closeWorkbook();
            logger.info("Excel workbooks closed successfully");
        }
    }
}