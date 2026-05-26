package com.vit.banking_automation_project.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vit.banking_automation_project.base.DriverFactory;
import com.vit.banking_automation_project.constants.FrameworkConstants;

public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT)
        );
    }

    public static WebElement visible(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static List<WebElement> visibleElements(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
        );
    }

    public static WebElement clickable(By locator) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static void clickElement(By locator) {
        clickable(locator).click();
    }

    public static void enterText(By locator, String text) {
        WebElement element = visible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        return visible(locator).getText();
    }

    public static void selectByVisibleText(By locator, String visibleText) {
        waitForDropdownOptions(locator);

        Select select = new Select(visible(locator));
        select.selectByVisibleText(visibleText);
    }

    public static void selectByIndex(By locator, int index) {
        getWait().until(driver -> {
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size() > index;
        });

        Select select = new Select(visible(locator));
        select.selectByIndex(index);
    }

    public static void waitForDropdownOptions(By locator) {
        getWait().until(driver -> {
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size() > 0;
        });
    }

    public static void waitForUrlContains(String text) {
        getWait().until(
                ExpectedConditions.urlContains(text)
        );
    }
}