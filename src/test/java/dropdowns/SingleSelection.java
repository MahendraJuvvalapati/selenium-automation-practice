package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelection {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dropdown = driver.findElement(By.id("country"));
		
		Select drop = new Select(dropdown);
		
//		#getValues
		
		List<WebElement> options = drop.getOptions();
		
		for(WebElement ele :options)
		{
			System.out.println(ele.getText());
		}
		
//		#selct the values in three methods
		
		drop.selectByValue("uk");
		
		Thread.sleep(3000);
		
		drop.selectByIndex(9);
		
		Thread.sleep(3000);
		
		drop.selectByVisibleText("United Kingdom");
		
		driver.quit();
		

	}

}
