package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
//		driver.switchTo().frame(0);
		
		WebElement ele1 = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		
		WebElement ele2=driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));
		
		Actions act = new Actions(driver);
//		#move to element
		
//		act.moveToElement(ele1).click().perform();
//		Thread.sleep(5000);
//		act.moveToElement(ele2).perform();
		
		act.moveToElement(ele1).moveToElement(ele2).build().perform(); //build and perform or only perform is enough
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
