package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://qavalidation.com/demo-form/");

//        name
		driver.findElement(By.name("g4072-fullname")).sendKeys("Selenium");
//        id
		driver.findElement(By.id("g4072-email")).sendKeys("test@selenium.com");

// 		link text & partiallink text
//        driver.findElement(By.linkText("HOME")).click();

//        driver.findElement(By.partialLinkText("HO")).click();

//      ClassName
		List<WebElement> topmenu = driver.findElements(By.className("menu-item-text"));
		System.out.println(topmenu.size());

//     tagname
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());

	}
}
