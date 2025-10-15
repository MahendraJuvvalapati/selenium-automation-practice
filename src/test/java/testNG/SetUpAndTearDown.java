package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetUpAndTearDown {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("✅ Browser launched and navigated to OrangeHRM login page");
	}

	@BeforeMethod
	public void loginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("✅ Logged in successfully");
	}

	@AfterMethod
	public void logoutTest() {
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		System.out.println("✅ Logged out successfully");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("✅ Browser closed");
	}
	
	@Test(priority = 2)
	public void search()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Admin");
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		boolean Heading=driver.findElement(By.xpath("//h6[text()='Admin']")).isDisplayed();
		
		Assert.assertTrue(Heading);
	}
	
	@Test(priority = 1)
	public void Buzz()
	{
		driver.findElement(By.xpath("//span[text()='Buzz']")).click();
		
		boolean Heading=driver.findElement(By.xpath("//h6[text()='Buzz']")).isDisplayed();
		
		Assert.assertTrue(Heading);
	}
}
