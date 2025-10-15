package testNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterized {

	@Test
	@Parameters("browser")
	public void loginTest(String browser) {
		 WebDriver driver = null;

	        // initialize driver based on browser parameter
	        if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        }		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		boolean isValid=driver.getPageSource().contains("Invalid credentials");
		
		if(!isValid)
		{
			driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			
			driver.close();
			
		}
		else
		{
			driver.close();
			Assert.fail("Invalid Credentials");
		}
		
	}
}
