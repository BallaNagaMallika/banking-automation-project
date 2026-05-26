package com.vit.bankingManagement.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class WaitUtils {

    private WaitUtils() {

    }

    private static WebDriverWait getWait(WebDriver driver) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        FrameworkConstants.EXPLICIT_WAIT));

    }

    public static WebElement waitForVisibility(
            WebDriver driver,
            By locator) {

        return getWait(driver)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(locator));

    }

    public static WebElement waitForClickable(
            WebDriver driver,
            By locator) {

        return getWait(driver)
                .until(ExpectedConditions
                        .elementToBeClickable(locator));

    }

    public static boolean waitForUrlContains(
            WebDriver driver,
            String value) {

        return getWait(driver)
                .until(ExpectedConditions
                        .urlContains(value));

    }

    public static boolean waitForTextPresent(
            WebDriver driver,
            By locator,
            String value) {

        return getWait(driver)
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(locator, value));

    }
    public static By getDynamicXpath(
            String xpath,
            String value) {

        return By.xpath(
                String.format(xpath, value));

    }
    
    

}