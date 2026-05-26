package com.vit.bankingManagement.tests;

import org.testng.annotations.Test;

import com.vit.bankingManagement.api.AuthAPI;
import com.vit.bankingManagement.api.ResponseValidator;

import io.restassured.response.Response;

public class AuthAPITest {

	@Test(priority = 8)
    public void verifyLoginAPI() {

        AuthAPI authAPI =
                new AuthAPI();

        Response response =
                authAPI.login();

        ResponseValidator.validateStatusCode(
                response,
                201);

        ResponseValidator.validateResponseTime(
                response,
                15000);

    }

}