package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://qavalidation.com/demo-form/");
		
//		#Xpath with single attribute
		driver.findElement(By.xpath("//input[@id='g4072-fullname']")).sendKeys("SeleniumXpath");
		
//		#Xpath with multiple attributes
		driver.findElement(By.xpath("//input[@id='g4072-email'][@type='email']")).sendKeys("Selenium@xpath.com");
		
//		#Xpath with And or operators
		driver.findElement(By.xpath("//input[@id='g4072-phonenumber' and @type='tel']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='g4072-phonenumber' and @type='tel']")).clear();
		driver.findElement(By.xpath("//input[@id='g4072-phonenumber' or @type='tel']")).sendKeys("0987654321");
		
//		#xpath with inner text
		
		driver.findElement(By.xpath("//*[text()='HOME']")).click();
		System.out.println(driver.findElement(By.xpath("//*[text()='HOME']")).isDisplayed());
		driver.findElement(By.xpath("//*[text()='DemoForm']")).click();
	}

}
