package com.vit.bankingManagement.api;

import com.vit.bankingManagement.utils.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private ApiUtils() {

    }

    public static RequestSpecification getRequestSpecification() {

        return RestAssured
                .given()
                .baseUri(ConfigReader.getProperty("apiBaseUrl"))
                .header("Content-Type", "application/json");

    }

}