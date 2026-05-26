package com.vit.bankingManagement.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vit.bankingManagement.base.DriverFactory;
import com.vit.bankingManagement.utils.ExtentManager;
import com.vit.bankingManagement.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final ExtentReports extentReports =
            ExtentManager.getReportInstance();

    private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {

        extentTest = extentReports.createTest(
                result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.fail(result.getThrowable());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            String screenshotPath =
                    ScreenshotUtils.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName());

            extentTest.addScreenCaptureFromPath(screenshotPath);

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.skip("Test Skipped");

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

    }

}