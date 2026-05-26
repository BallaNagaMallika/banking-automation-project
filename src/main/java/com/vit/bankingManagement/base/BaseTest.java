package com.vit.bankingManagement.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.vit.bankingManagement.pages.LoginPage;
import com.vit.bankingManagement.utils.ExcelReader;

public class BaseTest {

    protected WebDriver driver;

    protected Logger logger;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        DriverFactory.initializeBrowser();

        driver = DriverFactory.getDriver();

        logger = LogManager.getLogger(this.getClass());

        logger.info("========== Test Execution Started ==========");

    }
    protected void loginWithRuntimeUser() {

        LoginPage loginPage =
                new LoginPage(driver);

        String[] runtimeUser =
                ExcelReader.getLatestRuntimeUser();

        loginPage.login(
                runtimeUser[0],
                runtimeUser[1]);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitBrowser();

        logger.info("========== Test Execution Completed ==========");

    }

}