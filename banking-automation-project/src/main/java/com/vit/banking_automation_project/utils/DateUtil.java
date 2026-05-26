package com.vit.banking_automation_project.utils;
 
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
 
public class DateUtil {
 
 
    public static String getTimeStamp() {
 
        return new SimpleDateFormat(
                "yyyyMMdd_HHmmss"
        ).format(new Date());
    }
 
 
    public static String getCurrentDateTime() {
 
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"
                );
 
        return LocalDateTime.now()
                .format(formatter);
    }
    public static String generateUsername(
            String baseName
    ) {
 
        return baseName + "_"
                + getTimeStamp();
    }
 
 
    public static String generatePassword() {
 
        return "Pass@"
                + System.currentTimeMillis();
    }
 
    public static String generateTransferDescription(
            String description
    ) {
 
        return description + "_"
                + getTimeStamp();
    }
}