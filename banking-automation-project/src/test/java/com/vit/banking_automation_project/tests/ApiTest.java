package com.vit.banking_automation_project.tests;

import com.vit.banking_automation_project.api.LoginAPI;
import com.vit.banking_automation_project.api.UserAPI;
import com.vit.banking_automation_project.utils.ExcelUtil;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTest {

    private static final Logger log = Logger.getLogger(ApiTest.class);

    LoginAPI loginAPI = new LoginAPI();
    UserAPI userAPI = new UserAPI();

    ExcelUtil excelReader;

    static String token;
    static String userId;

    int firstDataRow;

    @BeforeClass
    public void setupExcel() {

        String apiExcelPath = System.getProperty("user.dir")
                + "/src/test/resources/ApiPayloadData.xlsx";

        excelReader = new ExcelUtil(apiExcelPath, "ApiPayloadData");

        firstDataRow = excelReader.getFirstDataRowIndex();

        log.info("API payload Excel file loaded successfully");
    }

    @Test(priority = 1)
    public void validateLoginAPI() {

        int loginRow = firstDataRow;

        String username = excelReader.getCellData(loginRow, "username");
        String password = excelReader.getCellData(loginRow, "password");

        int expectedStatusCode = Integer.parseInt(
                excelReader.getCellData(loginRow, "expectedStatusCode")
        );

        int maxResponseTime = Integer.parseInt(
                excelReader.getCellData(loginRow, "maxResponseTimeMs")
        );

        log.info("Starting Login API test");

        Response response = loginAPI.login(username, password);

        log.info("Login API Response: " + response.asPrettyString());

        Assert.assertEquals(
                response.statusCode(),
                expectedStatusCode,
                "Login API status code mismatch"
        );

        token = loginAPI.extractToken(response);

        Assert.assertNotNull(token, "Token is not generated");
        Assert.assertFalse(token.isEmpty(), "Token is empty");

        Assert.assertTrue(
                response.getTime() < maxResponseTime,
                "Login API response time is more than expected"
        );

        log.info("Generated Token: " + token);
        log.info("Login API test completed successfully");
    }

    @Test(priority = 2)
    public void validateCreateUserAPI() {

        int createUserRow = firstDataRow + 1;

        String email = excelReader.getCellData(createUserRow, "email");
        String namePrefix = excelReader.getCellData(createUserRow, "namePrefix");
        String password = excelReader.getCellData(createUserRow, "password");

        int expectedStatusCode = Integer.parseInt(
                excelReader.getCellData(createUserRow, "expectedStatusCode")
        );

        int maxResponseTime = Integer.parseInt(
                excelReader.getCellData(createUserRow, "maxResponseTimeMs")
        );

        log.info("Starting Create User API test");

        Response response = userAPI.createUser(namePrefix, email, password);

        log.info("Create User API Response: " + response.asPrettyString());

        Assert.assertEquals(
                response.statusCode(),
                expectedStatusCode,
                "Create User API status code mismatch"
        );

        userId = userAPI.extractUserId(response);

        Assert.assertNotNull(userId, "User ID is not generated");
        Assert.assertFalse(userId.isEmpty(), "User ID is empty");

        Assert.assertTrue(
                response.getTime() < maxResponseTime,
                "Create User API response time is more than expected"
        );

        log.info("Generated User ID: " + userId);
        log.info("Create User API test completed successfully");
    }

    @Test(priority = 3, dependsOnMethods = "validateCreateUserAPI")
    public void validateFetchUserDetailsAPI() {

        int fetchUserRow = firstDataRow + 2;

        String userIdForFetch = excelReader.getCellData(fetchUserRow, "userIdForFetch");

        int expectedStatusCode = Integer.parseInt(
                excelReader.getCellData(fetchUserRow, "expectedStatusCode")
        );

        int maxResponseTime = Integer.parseInt(
                excelReader.getCellData(fetchUserRow, "maxResponseTimeMs")
        );

        log.info("Starting Fetch User Details API test");

        Response response = userAPI.getUserDetails(userIdForFetch);

        log.info("Fetch User Details API Response: " + response.asPrettyString());

        Assert.assertEquals(
                response.statusCode(),
                expectedStatusCode,
                "Fetch User API status code mismatch"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("id"),
                Integer.parseInt(userIdForFetch),
                "User ID mismatch"
        );

        Assert.assertNotNull(response.jsonPath().getString("email"), "Email is missing");
        Assert.assertNotNull(response.jsonPath().getString("username"), "Username is missing");
        Assert.assertNotNull(response.jsonPath().getString("password"), "Password is missing");

        Assert.assertTrue(
                response.getTime() < maxResponseTime,
                "Fetch User API response time is more than expected"
        );

        log.info("Fetch User Details API test completed successfully");
    }

    @AfterClass
    public void closeExcel() {

        if (excelReader != null) {
            excelReader.closeWorkbook();
            log.info("API payload Excel file closed successfully");
        }
    }
}