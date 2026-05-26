package com.vit.bankingManagement.base;

import java.util.Collections;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {

    }

    public static void initializeBrowser() {

        logger.info("Initializing Browser : Chrome");

        ChromeOptions options =
                new ChromeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled");

        options.addArguments("--disable-notifications");

        options.addArguments("--disable-save-password-bubble");

        options.addArguments("--disable-popup-blocking");

        options.addArguments("--disable-infobars");

        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--guest");

        options.addArguments("--incognito");

        options.addArguments("--start-maximized");
       
     options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

     options.addArguments("--incognito"); 

 
  options.addArguments("--disk-cache-size=1");
  options.addArguments("--media-cache-size=1");
     options.setExperimentalOption("useAutomationExtension", false);

        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-automation"});

        options.setExperimentalOption(
                "useAutomationExtension",
                false);

        driver =
                new ChromeDriver(options);

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(0));

        driver.manage()
                .window()
                .setSize(new Dimension(1920, 1080));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        logger.info("Chrome Browser Launched Successfully");

    }

    public static WebDriver getDriver() {

        return driver;

    }

    public static void quitBrowser() {

        if (driver != null) {

            driver.quit();

            driver = null;

        }

    }

}