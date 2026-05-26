package com.vit.bankingManagement.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class ScreenshotUtils {

    private ScreenshotUtils() {

    }

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timeStamp = DateUtils.getTimeStamp();

        String screenshotName =
                testName + "_" + timeStamp + ".png";

        String screenshotPath =
                FrameworkConstants.SCREENSHOT_PATH + screenshotName;

        File sourceFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(screenshotPath);

        try {

            FileUtils.copyFile(sourceFile, destinationFile);

        } catch (IOException exception) {

            throw new RuntimeException("Failed To Capture Screenshot");
        }

        return screenshotPath;

    }

}