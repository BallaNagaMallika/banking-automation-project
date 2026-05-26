package com.vit.bankingManagement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class JsonUtils {

    private JsonUtils() {

    }

    public static String readJsonFile(String fileName) {

        try {

            return new String(
                    Files.readAllBytes(
                            Paths.get(
                                    FrameworkConstants.PAYLOAD_PATH + fileName)));

        } catch (IOException exception) {

            throw new RuntimeException("Failed To Read JSON File");
        }

    }

}