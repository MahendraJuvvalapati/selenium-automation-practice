package driverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		declartion using webdriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		
//		#using
		WebElement userName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userName.sendKeys("Admin");

		WebElement passWord = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		passWord.sendKeys("admin123");

		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

		loginBtn.click();
		
		Thread.sleep(5000);

		driver.quit();

		System.out.println("Test passed .....");

	}

}
