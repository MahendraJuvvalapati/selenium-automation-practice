package javaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInOut {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		JavascriptExecutor js=driver;
		
		System.out.println("Current Zoom Level :"+js.executeScript("return document.body.style.zoom"));
		
		Thread.sleep(3000);
		
		// Zoom In(150%)
		js.executeScript("document.body.style.zoom='150%'");
		
		System.out.println("Current Zoom Level :"+js.executeScript("return document.body.style.zoom"));
		
		Thread.sleep(3000);

		// Zoom Out (50%)
		js.executeScript("document.body.style.zoom='50%'");
		
		System.out.println("Current Zoom Level :"+js.executeScript("return document.body.style.zoom"));
		
		Thread.sleep(3000);

		// Reset to Normal (100%)
		js.executeScript("document.body.style.zoom='100%'");
		
		System.out.println("Current Zoom Level :"+js.executeScript("return document.body.style.zoom"));
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
