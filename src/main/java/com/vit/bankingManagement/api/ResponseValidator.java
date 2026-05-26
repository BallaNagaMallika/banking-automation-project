package com.vit.bankingManagement.api;

import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidator {

    private ResponseValidator() {

    }

    public static void validateStatusCode(
            Response response,
            int expectedStatusCode) {

        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatusCode);

    }

    public static void validateResponseTime(
            Response response,
            long expectedTime) {

        Assert.assertTrue(
                response.getTime() < expectedTime);

    }

    public static void validateResponseValue(
            Response response,
            String jsonPath,
            String expectedValue) {

        Assert.assertEquals(
                response.jsonPath().getString(jsonPath),
                expectedValue);

    }

}