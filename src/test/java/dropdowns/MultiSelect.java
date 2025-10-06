package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://stackblitz.com/edit/multiselect-checkbox-dropdown?file=src%2Fapp%2Fapp.component.ts");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Preview page']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[@class='drop-toggle btn flat']")).click();
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
//		#verify values selected
		
		boolean isSelected = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected();
		
		System.out.println(isSelected);
		
		System.out.println(driver.findElement(By.xpath("//button[@class='drop-toggle btn flat']")).getText());
		
		Thread.sleep(3000);
		
		
//		#getting all values from dropdown
		
		List<WebElement> dropdown = driver.findElements(By.cssSelector("div.drop-show label"));
		
		System.out.println(dropdown.size());
		
		for(WebElement ele : dropdown)
		{
			ele.click();
		}
		System.out.println(driver.findElement(By.xpath("//button[@class='drop-toggle btn flat']")).getText());
		Thread.sleep(3000);
		
		
		
//		#selecting if unselected
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("div.drop-show input[type='checkbox']"));
		
		for(WebElement ele :checkboxes)
		{
			if(!ele.isSelected())
			{
				ele.click();
			}
		}
		System.out.println(driver.findElement(By.xpath("//button[@class='drop-toggle btn flat']")).getText());
		Thread.sleep(3000);
		driver.quit();
	}

}
