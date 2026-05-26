package com.vit.bankingManagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {

    }

    public static String getTimeStamp() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

        return LocalDateTime.now().format(formatter);

    }

}