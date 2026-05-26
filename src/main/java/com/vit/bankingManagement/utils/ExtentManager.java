package com.vit.bankingManagement.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vit.bankingManagement.constants.FrameworkConstants;

public class ExtentManager {

    private static ExtentReports extentReports;

    private ExtentManager() {

    }

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            FrameworkConstants.EXTENT_REPORT_PATH);

            sparkReporter.config()
                    .setReportName("Enterprise Banking Automation Report");

            sparkReporter.config()
                    .setDocumentTitle("Automation Execution Report");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

        }

        return extentReports;

    }

}