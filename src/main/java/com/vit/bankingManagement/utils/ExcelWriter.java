package com.vit.bankingManagement.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class ExcelWriter {

    private ExcelWriter() {

    }

    public static void writeRuntimeUser(
            String username,
            String password) {

        XSSFWorkbook workbook = null;

        try {

            FileInputStream fileInputStream =
                    new FileInputStream(
                            FrameworkConstants.TEST_DATA_PATH);

            workbook =
                    new XSSFWorkbook(fileInputStream);

            XSSFSheet sheet =
                    workbook.getSheet("RuntimeUsers");

            int lastRow =
                    sheet.getLastRowNum();

            int newRow =
                    lastRow + 1;

            sheet.createRow(newRow)
                    .createCell(0)
                    .setCellValue(username);

            sheet.getRow(newRow)
                    .createCell(1)
                    .setCellValue(password);

            sheet.getRow(newRow)
                    .createCell(2)
                    .setCellValue(
                            LocalDateTime.now().toString());

            fileInputStream.close();

            FileOutputStream fileOutputStream =
                    new FileOutputStream(
                            FrameworkConstants.TEST_DATA_PATH);

            workbook.write(fileOutputStream);

            fileOutputStream.close();

            workbook.close();

            System.out.println(
                    "Runtime User Saved Successfully");

        } catch (IOException exception) {

            exception.printStackTrace();

            throw new RuntimeException(
                    "Failed To Write Runtime User");

        }

    }

}