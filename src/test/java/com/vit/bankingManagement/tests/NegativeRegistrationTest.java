package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.RegistrationPage;
import com.vit.bankingManagement.utils.ConfigReader;

public class NegativeRegistrationTest extends BaseTest {

	@Test(priority = 2)
    public void verifyMandatoryFieldValidation() {

        driver.get(ConfigReader.getProperty("baseUrl"));

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        registrationPage.clickRegisterLink();

        registrationPage.clickRegisterButton();

        Assert.assertEquals(
                registrationPage.getFirstNameError(),
                "First name is required.");

    }

}