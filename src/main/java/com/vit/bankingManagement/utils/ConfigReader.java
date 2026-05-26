package com.vit.bankingManagement.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            FileInputStream file = new FileInputStream(
                    FrameworkConstants.CONFIG_FILE_PATH);

            properties = new Properties();

            properties.load(file);

        } catch (IOException exception) {

            throw new RuntimeException("Failed To Load Config File");
        }

    }

    private ConfigReader() {

    }

    public static String getProperty(String key) {

        return properties.getProperty(key);

    }

}