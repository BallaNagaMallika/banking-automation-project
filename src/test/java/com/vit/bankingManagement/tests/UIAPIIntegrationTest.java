package com.vit.bankingManagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vit.bankingManagement.api.UserAPI;
import com.vit.bankingManagement.utils.ExcelReader;

import io.restassured.response.Response;

public class UIAPIIntegrationTest {

    @Test(priority = 11)
    public void verifyUIAPIIntegration() {

        UserAPI userAPI =
                new UserAPI();

        Response response =
                userAPI.createUser();

        Assert.assertEquals(
                response.getStatusCode(),
                201);

        String[] runtimeUser =
                ExcelReader.getLatestRuntimeUser();

        System.out.println(
                "Runtime Username : "
                        + runtimeUser[0]);

        System.out.println(
                "Generated User ID : "
                        + UserAPI.getUserId());

    }

}