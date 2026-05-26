package com.vit.banking_automation_project.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;
    private int headerRowIndex = 3;

    public ExcelUtil(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel file: " + filePath);
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Row row = sheet.getRow(rowNum);

        if (row == null) return "";

        Cell cell = row.getCell(colNum);

        if (cell == null) return "";

        return formatter.formatCellValue(cell).trim();
    }

    public String getCellData(int rowNum, String columnName) {
        int colNum = getColumnIndex(columnName);
        return getCellData(rowNum, colNum);
    }

    public Map<String, String> getRowData(int rowNum) {
        Map<String, String> data = new HashMap<>();
        Row headerRow = sheet.getRow(headerRowIndex);

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String key = getCellData(headerRowIndex, i);
            String value = getCellData(rowNum, i);
            data.put(key, value);
        }

        return data;
    }

    private int getColumnIndex(String columnName) {
        Row headerRow = sheet.getRow(headerRowIndex);

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String header = getCellData(headerRowIndex, i);

            if (header.replaceAll("\\s+", "")
                    .equalsIgnoreCase(columnName.replaceAll("\\s+", ""))) {
                return i;
            }
        }

        throw new RuntimeException("Column not found: " + columnName);
    }

    public int getFirstDataRowIndex() {
        return headerRowIndex + 1;
    }

    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to close workbook");
        }
    }
}