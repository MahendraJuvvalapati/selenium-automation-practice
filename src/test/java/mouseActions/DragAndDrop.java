package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);

//		#drag and drop
		act.dragAndDrop(from, to).perform();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
