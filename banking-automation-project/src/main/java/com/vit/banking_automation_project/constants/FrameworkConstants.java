package com.vit.banking_automation_project.constants;

public class FrameworkConstants {

    private FrameworkConstants() {

    }

    public static final String CONFIG_FILE_PATH =
            "src/main/resources/config.properties";

    public static final String EXCEL_FILE_PATH =
            "src/test/resources/testdata.xlsx";

    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir")
            + "/screenshots/";

    public static final String LOG_PATH =
            "logs/framework.log";

    public static final String REPORT_PATH =
            System.getProperty("user.dir")
            + "/reports/ExtentReport.html";

    public static final int EXPLICIT_WAIT =
            20;


    public static final int IMPLICIT_WAIT =
            0;
    public static final int PAGE_LOAD_TIMEOUT = 10;

}