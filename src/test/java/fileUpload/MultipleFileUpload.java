package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFileUpload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		String fileLocation1="D:\\Automation practice\\javaSelenium\\com.demo.selenium\\src\\test\\resources\\file1.txt";
		
		String fileLocation2="D:\\Automation practice\\javaSelenium\\com.demo.selenium\\src\\test\\resources\\file2.txt";
		
		WebElement multipleFileUpload = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", multipleFileUpload);
		
//		multipleFileUpload.sendKeys(fileLocation1);
//		multipleFileUpload.sendKeys(fileLocation2);
		
		
//		#multiple file upload
		multipleFileUpload.sendKeys(fileLocation1 + "\n" + fileLocation2);
		
		driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']")).click();
		
		System.out.println("files uploaded ....");
		
        Thread.sleep(3000);
		
		driver.quit();
		

	}

}
