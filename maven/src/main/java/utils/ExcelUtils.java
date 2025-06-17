package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static String filePath;

    public static void setExcelFile(String path) {
        filePath = path;
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    public static String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return cell.toString().trim();
    }

    public static void setCellData(String sheetName, int rowNum, int colNum, String data) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        cell.setCellValue(data);
        saveExcel();
    }

    public static int getRowByTestCaseID(String sheetName, String testCaseID) {
        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (getCellData(sheetName, i, 0).equals(testCaseID)) {
                return i;
            }
        }
        return -1;
    }

    private static void saveExcel() {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}