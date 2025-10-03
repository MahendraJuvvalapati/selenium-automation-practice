package driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//		#get()
		driver.get("https://qavalidation.com/demo-form/");
		
//		#getwindowHandle()
		System.out.println(driver.getWindowHandle());

		driver.findElement(By.xpath(
				"//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border border-off hover-accent-bg hover-disabled-border hover-border-off first last']//a[2]//span[1]"))
				.click();
//		#getWindowsHandle()		
		System.out.println(driver.getWindowHandles());
		
		
//		#close()- will not close all tabs in current windows.
		driver.close();
		Thread.sleep(5000);
		driver.quit();


	}

}
