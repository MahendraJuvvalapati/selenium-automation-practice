package driverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
//	#implicitWait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	
	Thread.sleep(5000);

	driver.quit();
	
	System.out.println("Test passed .....");

	}

}
