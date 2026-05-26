package com.vit.bankingManagement.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vit.bankingManagement.constants.FrameworkConstants;

public class ExcelReader {

    private ExcelReader() {

    }

    public static String getCellData(
            String sheetName,
            int rowNumber,
            int cellNumber) {

        try (
                FileInputStream file =
                        new FileInputStream(
                                FrameworkConstants.TEST_DATA_PATH);

                XSSFWorkbook workbook =
                        new XSSFWorkbook(file)
        ) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(
                    sheet.getRow(rowNumber)
                            .getCell(cellNumber));

        } catch (IOException exception) {

            throw new RuntimeException("Failed To Read Excel Data");
        }
        

    }
    public static String[] getLatestRuntimeUser() {

        try (
                FileInputStream file =
                        new FileInputStream(
                                FrameworkConstants.TEST_DATA_PATH);

                XSSFWorkbook workbook =
                        new XSSFWorkbook(file)
        ) {

            XSSFSheet sheet =
                    workbook.getSheet("RuntimeUsers");

            int lastRow =
                    sheet.getLastRowNum();

            String username =
                    sheet.getRow(lastRow)
                            .getCell(0)
                            .getStringCellValue();

            String password =
                    sheet.getRow(lastRow)
                            .getCell(1)
                            .getStringCellValue();

            return new String[]{
                    username,
                    password
            };

        } catch (IOException exception) {

            throw new RuntimeException(
                    "Failed To Read Runtime User");

        }

    }
}