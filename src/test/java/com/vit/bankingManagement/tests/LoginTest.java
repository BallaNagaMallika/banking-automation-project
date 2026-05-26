package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.HomePage;

import com.vit.bankingManagement.utils.ConfigReader;


public class LoginTest extends BaseTest {

    @Test(priority = 3)
    public void verifyLogin() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        loginWithRuntimeUser();

        HomePage homePage =
                new HomePage(driver);

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("overview"));
    }

}