package com.vit.banking_automation_project.tests;

import com.vit.banking_automation_project.base.BaseClass;
import com.vit.banking_automation_project.pages.HomePage;
import com.vit.banking_automation_project.pages.RegistrationPage;
import com.vit.banking_automation_project.utils.DateUtil;
import com.vit.banking_automation_project.utils.ExcelUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class RegistrationTest extends BaseClass {

    private static final Logger log = Logger.getLogger(RegistrationTest.class);

    @Test(priority = 1, description = "Validate Positive Customer Registration with Dynamic Data")
    public void validateCustomerRegistration() {

        String customerExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/CustomerData.xlsx";

        ExcelUtil excel = new ExcelUtil(customerExcelPath, "CustomerData");

        try {
            int customerRow = excel.getFirstDataRowIndex();
            Map<String, String> customer = excel.getRowData(customerRow);

            String username = DateUtil.generateUsername(customer.get("usernamePrefix"));
            String password = customer.get("passwordPrefix") + DateUtil.getTimeStamp();

            HomePage homePage = new HomePage(driver);
            RegistrationPage registerPage = new RegistrationPage(driver);

            log.info("Navigating to registration page");
            homePage.clickRegister();

            log.info("Registering customer with username: " + username);
            registerPage.registerCustomer(customer, username, password);

            log.info("Runtime username: " + username);
            log.info("Runtime password: " + password);
            log.info("Current URL: " + driver.getCurrentUrl());

            String pageSource = driver.getPageSource();

            Assert.assertTrue(
                    pageSource.contains("Your account was created successfully")
                            || pageSource.contains("Welcome")
                            || pageSource.contains(username),
                    "Registration success message is not displayed. Page source validation failed."
            );

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("register.htm"),
                    "URL validation failed"
            );

            log.info("Customer registration completed successfully");

        } finally {
            excel.closeWorkbook();
            log.info("Customer Excel workbook closed successfully");
        }
    }

    @Test(priority = 2, description = "Validate Negative Registration Workflow with Blank Details")
    public void validateNegativeRegistration() {

        HomePage homePage = new HomePage(driver);
        RegistrationPage registerPage = new RegistrationPage(driver);

        log.info("Navigating to registration page");
        homePage.clickRegister();

        log.info("Submitting registration form with blank details");
        registerPage.clickRegisterButton();

        List<String> errors = registerPage.getValidationErrors();

        log.info("Validation errors displayed: " + errors);

        Assert.assertFalse(
                errors.isEmpty(),
                "No validation messages were displayed!"
        );

        Assert.assertTrue(
                errors.contains("First name is required."),
                "First Name validation message is missing."
        );

        Assert.assertTrue(
                errors.contains("Username is required."),
                "Username validation message is missing."
        );

        Assert.assertTrue(
                registerPage.isRegistrationFormDisplayed(),
                "Application crashed or navigated away incorrectly after bad submission."
        );

        log.info("Negative registration validation completed successfully");
    }
}