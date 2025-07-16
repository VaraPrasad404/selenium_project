package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.nio.file.*;

public class ExcelWriter {

    public static void writeProductsToExcel(List<Product> productList, String filePath) {
        File file = new File(filePath);
        Workbook workbook;
        Sheet sheet;

        try {
            if (!file.exists()) {
                // ✅ File doesn't exist – create new workbook and sheet
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Sorted Products");

                // Create headers
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Product Name");
                headerRow.createCell(1).setCellValue("Product Price");

            } else {
                // ✅ File exists – open and append to it
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();
            }

            // Determine next row to write to
            int rowNum = sheet.getLastRowNum() + 1;

            for (Product p : productList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(p.getName());
                row.createCell(1).setCellValue(p.getPrice());
            }

            // Auto-size columns
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            // Write changes to file
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
                workbook.close();
                System.out.println("✅ Excel written successfully to: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}