package dataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		
//		#fileLocation
		File fileLoc=new File(System.getProperty("user.dir") + "\\TestData\\Books.xlsx");
		
//		#file input stream for reading data
		FileInputStream fis = new FileInputStream(fileLoc);
		
//		#workbook
		XSSFWorkbook workBook=new XSSFWorkbook(fis);
		
//		#sheetName
		XSSFSheet sheet1 = workBook.getSheet("Sheet1");
		
//		#rows
		int noOfRows = sheet1.getLastRowNum();
		
//		#columns
		int noOfColumns = sheet1.getRow(0).getLastCellNum();
		
		System.out.println("No of rows :"+noOfRows);
		
		System.out.println("No of columns :"+noOfColumns);
		
		for(int i=0;i<=noOfRows;i++)
		{
			for(int j=0;j<noOfColumns;j++)
			{
				String s=sheet1.getRow(i).getCell(j).toString();
				
				System.out.println(s+" "+"("+i+","+j+")");
			}
//			System.out.println();
		}
		
		workBook.close();
		fis.close();
		

	}

}
