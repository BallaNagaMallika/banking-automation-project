package com.vit.banking_automation_project.api;

import com.vit.banking_automation_project.utils.DateUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserAPI extends ApiBase {

    public Response createUser(String baseUsername, String email, String password) {

        String runtimeUserName = DateUtil.generateUsername(baseUsername);

        Map<String, Object> name = new HashMap<>();
        name.put("firstname", "Test");
        name.put("lastname", "User");

        Map<String, Object> address = new HashMap<>();
        address.put("city", "Hyderabad");
        address.put("street", "Main Road");
        address.put("number", 10);
        address.put("zipcode", "500001");

        Map<String, Object> geolocation = new HashMap<>();
        geolocation.put("lat", "-37.3159");
        geolocation.put("long", "81.1496");

        address.put("geolocation", geolocation);

        Map<String, Object> payload = new HashMap<>();
        payload.put("email", email);
        payload.put("username", runtimeUserName);
        payload.put("password", password);
        payload.put("name", name);
        payload.put("address", address);
        payload.put("phone", "9876543210");

        return post("/users", payload);
    }

    public String extractUserId(Response response) {
        return response.jsonPath().getString("id");
    }

    public Response getUserDetails(String userId) {
        return get("/users/" + userId);
    }
}