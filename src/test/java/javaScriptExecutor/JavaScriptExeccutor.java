package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExeccutor {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='sunday']"));
		
//		#use js executor when we get element intercept exection due to element is hidden
		
//		#declartion
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
//		Alternate for send keys()
		js.executeScript("arguments[0].value='Selenium WebDriver'", inputName);
		
//		Alternate for click
		js.executeScript("arguments[0].click()", checkBox);
		
		
		driver.quit();

	}

}
