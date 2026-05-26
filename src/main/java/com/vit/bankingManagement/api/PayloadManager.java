package com.vit.bankingManagement.api;

import org.json.JSONObject;

import com.vit.bankingManagement.utils.ExcelReader;
import com.vit.bankingManagement.utils.RandomDataUtils;

public class PayloadManager {

    private PayloadManager() {

    }

    public static String createUserPayload() {

        String firstName =
                ExcelReader.getCellData(
                        "APIData",
                        1,
                        0);

        String lastName =
                ExcelReader.getCellData(
                        "APIData",
                        1,
                        1);

        String username =
                RandomDataUtils.generateUsername();

        String password =
                RandomDataUtils.generatePassword();

        JSONObject nameObject = new JSONObject();

        nameObject.put("firstname", firstName);
        nameObject.put("lastname", lastName);

        JSONObject geoLocationObject = new JSONObject();

        geoLocationObject.put("lat", "40.7128");
        geoLocationObject.put("long", "-74.0060");

        JSONObject addressObject = new JSONObject();

        addressObject.put("city", "New York");
        addressObject.put("street", "Wall Street");
        addressObject.put("number", 10);
        addressObject.put("zipcode", "10001");
        addressObject.put("geolocation", geoLocationObject);

        JSONObject requestBody = new JSONObject();

        requestBody.put("email", username + "@gmail.com");
        requestBody.put("username", username);
        requestBody.put("password", password);
        requestBody.put("name", nameObject);
        requestBody.put("address", addressObject);
        requestBody.put("phone", "9999999999");

        return requestBody.toString();

    }

}