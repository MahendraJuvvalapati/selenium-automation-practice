package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingFromDropdowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		WebElement yr = driver.findElement(By.xpath("//select[@aria-label='Select year']"));

		Select selectYear = new Select(yr);

		selectYear.selectByVisibleText("2016");

		WebElement mnth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));

		Select selectMonth = new Select(mnth);

		selectMonth.selectByVisibleText("Jan");
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement date:allDates)
		{
			if(date.getText().equals("19"))
			{
				date.click();
			}
		}
		
		String selectedDate=driver.findElement(By.xpath("//input[@id='txtDate']")).getAttribute("value");
		
		System.out.println("Selected Date is :"+ selectedDate);
		
		Thread.sleep(3000);
		driver.quit();

	}

}
