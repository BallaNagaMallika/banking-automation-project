package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.RegistrationPage;
import com.vit.bankingManagement.utils.ConfigReader;
import com.vit.bankingManagement.utils.ExcelReader;
import com.vit.bankingManagement.utils.ExcelWriter;
import com.vit.bankingManagement.utils.RandomDataUtils;

public class RegistrationTest extends BaseTest {

    @Test(priority = 1)
    public void verifyCustomerRegistration() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String runtimeUsername =
                RandomDataUtils.generateUsername();

        String runtimePassword =
                RandomDataUtils.generatePassword();

        registrationPage.clickRegisterLink();

        registrationPage.enterFirstName(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        0));

        registrationPage.enterLastName(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        1));

        registrationPage.enterAddress(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        2));

        registrationPage.enterCity(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        3));

        registrationPage.enterState(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        4));

        registrationPage.enterZipCode(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        5));

        registrationPage.enterPhone(
                ExcelReader.getCellData(
                        "RegistrationData",
                        1,
                        6));

        registrationPage.enterSSN("123456789");

        registrationPage.enterUsername(
                runtimeUsername);

        registrationPage.enterPassword(
                runtimePassword);

        registrationPage.enterConfirmPassword(
                runtimePassword);

        registrationPage.clickRegisterButton();

        Assert.assertTrue(
                registrationPage.getWelcomeMessage()
                        .contains("Welcome"));

        ExcelWriter.writeRuntimeUser(
                runtimeUsername,
                runtimePassword);

    }

}