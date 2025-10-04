package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://ui.vision/demo/webtest/frames/");
		
//		#switching to frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("inside frame3");
		Thread.sleep(3000);
		
		driver.switchTo().frame(0); //#nested Frame
		
		driver.findElement(By.xpath("//input[@aria-label='Other response']")).sendKeys("inside Nested Frame of frame 3");
		Thread.sleep(3000);
		
//		#switching back to default
		driver.switchTo().defaultContent();
		
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
