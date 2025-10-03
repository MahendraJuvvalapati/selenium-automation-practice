package driverMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//		#get()
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
//		#getWindowsHandle()		
		Set<String> windowsID = driver.getWindowHandles();
		System.out.println(windowsID);
		
//		for (String id : windowsID) {
//			System.out.println(driver.getTitle() + ":" + id);
//			driver.switchTo().window(id);
//			Thread.sleep(5000);
//		}
		
//		#converting to list
		List<String> windowsList = new ArrayList<>(windowsID);
        
		String parentWindow = windowsList.get(0);
		String childWindow = windowsList.get(1);
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childWindow);


	}

}
