package dataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExistingFile {

    public static void main(String[] args) throws IOException {

        // Path to existing Excel file
        File fileLoc = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\TestData\\dynamic.xlsx");

        // Open existing file
        FileInputStream fis = new FileInputStream(fileLoc);
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheet("UserInput");

        // If sheet doesn’t exist (first run), create it
        if (sheet == null) {
            sheet = workBook.createSheet("UserInput");
        }

        Scanner sc = new Scanner(System.in);

        // Find the last row number (so we can append after it)
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("Existing data ends at row: " + lastRowNum);

        // Ask for new data
        System.out.println("Enter data for 2 new rows (each with 2 cells):");

        for (int i = 1; i <= 2; i++) {
            XSSFRow row = sheet.createRow(lastRowNum + i);
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value for cell (" + (lastRowNum + i) + "," + j + "): ");
                String value = sc.next();
                row.createCell(j).setCellValue(value);
            }
        }

        // Close input stream before writing
        fis.close();

        // Write updated data back to same file
        FileOutputStream fos = new FileOutputStream(fileLoc);
        workBook.write(fos);

        System.out.println("✅ Data appended successfully to Excel file.");

        // Close all resources
        fos.close();
        workBook.close();
        sc.close();
    }
}
