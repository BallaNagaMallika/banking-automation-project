package com.vit.bankingManagement.api;

import com.vit.bankingManagement.utils.JsonUtils;

import io.restassured.response.Response;

public class AuthAPI {

    private static String token;

    public Response login() {

        String requestBody =
                JsonUtils.readJsonFile("login.json");

        Response response =
                ApiUtils.getRequestSpecification()
                        .body(requestBody)
                        .post("/auth/login");

        token =
                response.jsonPath()
                        .getString("token");

        return response;

    }

    public static String getToken() {

        return token;

    }

}