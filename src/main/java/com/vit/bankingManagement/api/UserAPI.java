package com.vit.bankingManagement.api;

import io.restassured.response.Response;

public class UserAPI {

    private static int userId;

    public Response createUser() {

        String requestBody =
                PayloadManager.createUserPayload();

        Response response =
                ApiUtils.getRequestSpecification()
                        .body(requestBody)
                        .post("/users");

        userId =
                response.jsonPath()
                        .getInt("id");

        return response;

    }

    public Response getUserDetails() {

        return ApiUtils.getRequestSpecification()
                .get("/users/" + userId);

    }

    public static int getUserId() {

        return userId;

    }

}