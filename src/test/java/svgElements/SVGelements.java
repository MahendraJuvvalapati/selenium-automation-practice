package svgElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGelements {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		#xpath is different for svg elements
		WebElement ele= driver.findElement(By.xpath("//div[@class='svg-container']//*[name()='svg'][1]"));
		
		System.out.println(ele.getSize());

	}

}
