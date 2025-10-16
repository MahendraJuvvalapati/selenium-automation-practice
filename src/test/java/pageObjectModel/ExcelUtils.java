package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static String[][] loginData(String filePath,String sheetName) throws IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int noOfRows=sheet.getLastRowNum();
		
		int noOfColumns=sheet.getRow(1).getLastCellNum();
		
		System.out.println(noOfRows+ " "+noOfColumns);
		
		String[][] data=new String[noOfRows][noOfColumns];
		
		for(int i=1;i<=noOfRows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0;j<noOfColumns;j++)
			{
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j]=cell.toString(); //i-1 is for indexing of strings start from zero;
			}
		}
		workbook.close();
        fis.close();
		return data;
		
	}

}
