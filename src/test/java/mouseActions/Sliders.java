package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliders {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
		
		System.out.println("Before Sliding :"+slider.getLocation());
		
		String priceRange = driver.findElement(By.xpath("//input[@id='amount']")).getAttribute("value");
		
		System.out.println("Price range :"+priceRange);
		
		Actions act = new Actions(driver);
//		#dragand drop with co-ordinates
		act.dragAndDropBy(slider, 50, 0).perform();
		
		System.out.println("After Sliding :"+slider.getLocation());
		
		priceRange = driver.findElement(By.xpath("//input[@id='amount']")).getAttribute("value");
		System.out.println("Price Range :"+priceRange);
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}
