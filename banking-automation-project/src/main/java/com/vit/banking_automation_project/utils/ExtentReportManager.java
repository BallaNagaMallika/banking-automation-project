package com.vit.banking_automation_project.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vit.banking_automation_project.constants.FrameworkConstants;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    private ExtentReportManager() {

    }

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            File reportFolder = new File("reports");

            if (!reportFolder.exists()) {
                reportFolder.mkdirs();
            }

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);

            reporter.config().setReportName("Banking Automation Report");
            reporter.config().setDocumentTitle("Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);

            extentReports.setSystemInfo("Project", "Banking Automation Project");
            extentReports.setSystemInfo("Framework", "Selenium + TestNG + REST Assured");
            extentReports.setSystemInfo("Tester", "Shiva");
            extentReports.setSystemInfo("Environment", "QA");
        }

        return extentReports;
    }
}