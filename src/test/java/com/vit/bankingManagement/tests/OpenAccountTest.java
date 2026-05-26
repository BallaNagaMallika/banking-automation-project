package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.base.BaseTest;
import com.vit.bankingManagement.pages.HomePage;
import com.vit.bankingManagement.pages.OpenAccountPage;
import com.vit.bankingManagement.utils.ConfigReader;

public class OpenAccountTest extends BaseTest {

    @Test(priority = 4)
    public void verifyOpenAccount() {

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        loginWithRuntimeUser();

        HomePage homePage =
                new HomePage(driver);

        homePage.clickOpenAccount();

        OpenAccountPage openAccountPage =
                new OpenAccountPage(driver);

        openAccountPage.selectAccountType("SAVINGS");

        openAccountPage.clickOpenAccountButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Congratulations"));

    }

}