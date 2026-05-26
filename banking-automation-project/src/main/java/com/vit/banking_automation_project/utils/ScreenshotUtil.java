package com.vit.banking_automation_project.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vit.banking_automation_project.base.DriverFactory;
import com.vit.banking_automation_project.constants.FrameworkConstants;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        String screenshotName = testName + "_" + DateUtil.getTimeStamp() + ".png";

        String path = FrameworkConstants.SCREENSHOT_PATH + screenshotName;

        File screenshotFolder = new File(FrameworkConstants.SCREENSHOT_PATH);

        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdirs();
        }

        File srcFile = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(path);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot: " + path, e);
        }

        return path;
    }
}