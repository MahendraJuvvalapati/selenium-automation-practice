package driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//		#get()
		driver.get("https://qavalidation.com/demo-form/");

//		#isDisplayed()
		boolean statusOfSearch =driver.findElement(By.id("the7-search")).isDisplayed();
		System.out.println("Search bar is displayed :"+statusOfSearch);

//		#isEnabled()
		boolean statusOfInput= driver.findElement(By.xpath("//input[@id='g4072-fullname']")).isEnabled();
		System.out.println("Input is enabled :"+statusOfInput);

//		#isselected()
		boolean statusOfRadio =driver.findElement(By.xpath("//input[@id='g4072-yearsofexperience-1']")).isSelected();
		System.out.println("Radio is enabled ?: "+statusOfRadio);
		
		driver.findElement(By.xpath("//input[@id='g4072-yearsofexperience-2']")).click();
		statusOfRadio =driver.findElement(By.xpath("//input[@id='g4072-yearsofexperience-2']")).isSelected();
		System.out.println("Radio is enabled ? :"+statusOfRadio);
		
	}

}
