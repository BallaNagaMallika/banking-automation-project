package com.vit.bankingManagement.tests;

import org.testng.annotations.Test;

import com.vit.bankingManagement.api.ResponseValidator;
import com.vit.bankingManagement.api.UserAPI;

import io.restassured.response.Response;

public class FetchUserAPITest {
	
	@Test(priority = 10)
        public void verifyFetchUserAPI() {

        UserAPI userAPI =
                new UserAPI();

        Response response =
                userAPI.getUserDetails();

        ResponseValidator.validateStatusCode(
                response,
                200);

        ResponseValidator.validateResponseTime(
                response,
                3000);

    }

}