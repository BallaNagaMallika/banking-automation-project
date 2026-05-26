package com.vit.banking_automation_project.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginAPI extends ApiBase {

    public Response login(String username, String password) {

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", password);

        return post("/auth/login", payload);
    }

    public String extractToken(Response response) {
        return response.jsonPath().getString("token");
    }
}