package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.api.ResponseValidator;
import com.vit.bankingManagement.api.UserAPI;

import io.restassured.response.Response;

public class CreateUserAPITest {

	@Test(priority = 9)
    public void verifyCreateUserAPI() {

        UserAPI userAPI =
                new UserAPI();

        Response response =
                userAPI.createUser();

        ResponseValidator.validateStatusCode(
                response,
                201);

        ResponseValidator.validateResponseTime(
                response,
                3000);

        Assert.assertTrue(
                UserAPI.getUserId() > 0);

    }

}