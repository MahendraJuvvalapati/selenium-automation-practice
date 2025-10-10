package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		JavascriptExecutor js=driver;
		
		System.out.println("Before Scroll: "+js.executeScript("return window.pageYOffset"));
		
		// scrolls to absolute position
		js.executeScript("window.scrollTo(0, 1000);"); 
		
		System.out.println("After Scroll :"+js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(3000);
		
//		#Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		System.out.println("At Bottom :"+js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(3000);
		
//		scroll to top
		js.executeScript("window.scrollTo(0, 0);");
		
		System.out.println("At Top :"+js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']"));
		
//		Scroll till element Visible
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println("Element Visible at :"+js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
