package dataFromExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageExample {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		String fileLoc="D:\\Automation practice\\javaSelenium\\com.demo.selenium\\TestData\\credentials.xlsx";
		
		FileInputStream fis = new FileInputStream(fileLoc);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		
		int columns=sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			String userName=row.getCell(0).toString();
			String password=row.getCell(1).toString();
			
			driver.findElement(By.name("username")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(password);
			
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			
			System.out.print("Performing login with "+userName+" "+password+" : ");
			
			boolean isValid=driver.getPageSource().contains("Invalid credentials");
			
			if(!isValid)
			{
				driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				
				System.out.println("Login Succesfull....");
			}
			else
			{
				System.out.println("Login Failed due to invalid creds.....");
			}
		}
		
		fis.close();
		workbook.close();
		driver.quit();

	}

}
