package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		String fileLocation="D:\\Automation practice\\javaSelenium\\com.demo.selenium\\src\\test\\resources\\file1.txt";
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", fileUpload);
		
//		# using sendkeys with file location
		
		fileUpload.sendKeys(fileLocation);
		
		driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		
		if(fileUpload.getAttribute("value").contains("file1.txt"))
		{
			System.out.println("File Uploaded Succesfully ...");
		}
		else
		{
			System.out.println("File not Uploaded..");
		}
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
