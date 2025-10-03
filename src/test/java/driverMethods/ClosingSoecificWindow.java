package driverMethods;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSoecificWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		List<WebElement> links = driver.findElements(By.partialLinkText("Selenium"));
		
		System.out.println("No of Links :"+links.size());
		
		List<String> windowIDs= new LinkedList<String>();
		
		for(WebElement ele :links)
		{
			ele.click();
			
		}
		windowIDs.addAll(driver.getWindowHandles());
		for(String id :windowIDs)
		{
			driver.switchTo().window(id);
			System.out.println(driver.getTitle());
			
			if(driver.getTitle().equalsIgnoreCase("Selenium dioxide - Wikipedia")) {
				driver.close();
			}
		}
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
