package com.vit.banking_automation_project.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vit.banking_automation_project.listener.TestListener;
import com.vit.banking_automation_project.utils.ConfigReader;
@Listeners(TestListener.class)
public class BaseClass {

    protected Logger logger = Logger.getLogger(this.getClass());

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        driver = DriverFactory.getDriver();

        logger.info("Browser launched successfully");

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("baseUrl")
        );

        logger.info("Application launched successfully");
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Closing browser");

        DriverFactory.quitDriver();
    }
}