package com.vit.bankingManagement.utils;

import java.util.Random;

public class RandomDataUtils {

    private static final Random random = new Random();

    private RandomDataUtils() {

    }

    public static String generateUsername() {

        return "user" + random.nextInt(99999);

    }

    public static String generatePassword() {

        return "Pass@" + random.nextInt(99999);

    }

    public static String generateTransferDescription() {

        return "Transfer_" + DateUtils.getTimeStamp();

    }

}