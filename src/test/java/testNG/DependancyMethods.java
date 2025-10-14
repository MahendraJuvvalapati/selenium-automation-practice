package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyMethods { 
	
	public static WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void openApplication() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	@Test(dependsOnMethods = "openApplication")
	public void enterCredentials() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
//		Assert.assertEquals(false, true); // this will make test case fail so the dependent test will be skipped....
	}

	@Test(dependsOnMethods = "enterCredentials")
	public void submit() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Test(dependsOnMethods = "submit" )
	public void logout() {
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

	@Test(dependsOnMethods = "logout")
	public void closeBrowser() {
		driver.quit();
	}

}
