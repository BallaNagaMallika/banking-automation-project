package com.vit.banking_automation_project.api;

import com.vit.banking_automation_project.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiBase {

    public ApiBase() {
        RestAssured.baseURI = ConfigReader.getProperty("apiBaseUrl");
    }

    public RequestSpecification requestSpec() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    public Response post(String endpoint, Map<String, Object> payload) {
        return requestSpec()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response get(String endpoint) {
        return requestSpec()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}