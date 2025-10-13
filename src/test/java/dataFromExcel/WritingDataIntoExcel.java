package dataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		File fileLoc = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\TestData\\Write.xlsx");

//		#file output stream for writing data
		FileOutputStream fos = new FileOutputStream(fileLoc);

		XSSFWorkbook workBook = new XSSFWorkbook();
		
		
//		creating sheet
		XSSFSheet sheet = workBook.createSheet("Data");
		
		System.out.println("Created sheet ...");
		
//		adding data to row1
		XSSFRow row1 = sheet.createRow(0);
		XSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue("Username");
		row1.createCell(1).setCellValue("Password");
		System.out.println("Added row1...");
		
//		adding data to row2
		XSSFRow row2 = sheet.createRow(1);
		XSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue("Admin");
		row2.createCell(1).setCellValue("admin123");
		System.out.println("Added row2....");
		
//		adding data to row3
		XSSFRow row3 = sheet.createRow(2);
		XSSFCell cell3 = row3.createCell(0);
		cell3.setCellValue("admin");
		row3.createCell(1).setCellValue("admin");
		System.out.println("Added row3....");
		
//		adding data to row4
		XSSFRow row4 = sheet.createRow(3);
		XSSFCell cell4 = row4.createCell(0);
		cell4.setCellValue("Admin");
		row4.createCell(1).setCellValue("admin1234");
		System.out.println("Added row4....");
		
		workBook.write(fos);
		workBook.close();
		fos.close();

	}

}
