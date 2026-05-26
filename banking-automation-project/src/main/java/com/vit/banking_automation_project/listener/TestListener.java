package com.vit.banking_automation_project.listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.vit.banking_automation_project.base.DriverFactory;
import com.vit.banking_automation_project.utils.ExtentReportManager;
import com.vit.banking_automation_project.utils.ScreenshotUtil;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger log = Logger.getLogger(TestListener.class);
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        ExtentTest test = ExtentReportManager
                .getReportInstance()
                .createTest(testName);

        extentTest.set(test);

        log.info("Test started: " + testName);
    }

   @Override
public void onTestSuccess(ITestResult result) {

    String testName = result.getMethod().getMethodName();

    log.info("Test passed: " + testName);

    if (DriverFactory.getDriver() != null) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(testName + "_PASS");

        extentTest.get().log(Status.PASS, "Test passed");

        extentTest.get().addScreenCaptureFromPath(screenshotPath);

        log.info("Success screenshot captured: " + screenshotPath);

    } else {

        extentTest.get().log(Status.PASS, "Test passed");

        log.error("Driver is null. Success screenshot not captured.");
    }
}
    @Override
public void onTestFailure(ITestResult result) {

    String testName = result.getMethod().getMethodName();

    log.error("Test failed: " + testName, result.getThrowable());

    if (DriverFactory.getDriver() != null) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(testName + "_FAIL");

        extentTest.get().log(Status.FAIL, result.getThrowable());

        extentTest.get().addScreenCaptureFromPath(screenshotPath);

        log.info("Failure screenshot captured: " + screenshotPath);

    } else {

        extentTest.get().log(Status.FAIL, result.getThrowable());

        log.error("Driver is null. Failure screenshot not captured.");
    }
}
    @Override
    public void onTestSkipped(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        extentTest.get().log(Status.SKIP, "Test skipped");
        log.info("Test skipped: " + testName);
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        log.info("Test execution finished: " + context.getName());

        ExtentReportManager.getReportInstance().flush();

        extentTest.remove();
    }
}