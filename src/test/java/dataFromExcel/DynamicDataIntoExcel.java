package dataFromExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicDataIntoExcel {

    public static void main(String[] args) throws IOException {

        File fileLoc = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\TestData\\dynamic.xlsx");

        Scanner sc = new Scanner(System.in);

        // Create workbook and sheet
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("UserInput");

        // Get data from user
        System.out.println("Enter data for 2x2 Excel sheet:");

        for (int i = 0; i < 2; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value for cell (" + i + "," + j + "): ");
                String value = sc.next();
                row.createCell(j).setCellValue(value);
            }
        }

        // Write workbook to file
        FileOutputStream fos = new FileOutputStream(fileLoc);
        workBook.write(fos);

        System.out.println("✅ Data written successfully to Excel file.");

        // Close resources
        fos.close();
        workBook.close();
        sc.close();
    }
}
