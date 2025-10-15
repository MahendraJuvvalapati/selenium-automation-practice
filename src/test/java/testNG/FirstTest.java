package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

	public static WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void openApplication() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2)
	public void enterCredentials() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@Test(priority = 3)
	public void submit() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Test(priority = 4)
	public void logout() {
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

	@Test(priority = 5)
	public void closeBrowser() {
		driver.quit();
	}
}
