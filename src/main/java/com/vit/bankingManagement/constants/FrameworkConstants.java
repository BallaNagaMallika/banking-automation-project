package com.vit.bankingManagement.constants;

public class FrameworkConstants {

    private FrameworkConstants() {

    }

    // Configuration File
    public static final String CONFIG_FILE_PATH =
            "src/main/resources/config.properties";

    // Excel File
    public static final String TEST_DATA_PATH =
            "src/main/resources/testdata/testdata.xlsx";

    // Screenshot Folder
    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir") + "/screenshots/";

    // Extent Report
    public static final String EXTENT_REPORT_PATH =
            System.getProperty("user.dir") + "/reports/ExtentReport.html";

    // Payload Folder
    public static final String PAYLOAD_PATH =
            "src/main/resources/payloads/";

    // Log Folder
    public static final String LOG_PATH =
            System.getProperty("user.dir") + "/logs/";

    // Base URL
    public static final String BASE_URL =
            "https://parabank.parasoft.com/parabank/index.htm";

    // API Base URL
    public static final String API_BASE_URL =
            "https://fakestoreapi.com/";

    // Explicit Wait
    public static final int EXPLICIT_WAIT = 15;

}