package driverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new  ChromeDriver();
		
		driver.manage().window().maximize();
		
//		#get accepts string only
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.navigate().to("https://qavalidation.com/demo-form/");
//      #accepts objects tooo.     
		URL myUrl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(myUrl);
		
		System.out.println("Title :"+ driver.getTitle());
		System.out.println("Current URl "+driver.getCurrentUrl());
		
//		#navigating back
		driver.navigate().back();
		System.out.println("Title :"+ driver.getTitle());
		System.out.println("Current URl "+driver.getCurrentUrl());
		
//		#navigating forward
		driver.navigate().forward();
		System.out.println("Title :"+ driver.getTitle());
		System.out.println("Current URl "+driver.getCurrentUrl());
		
//		#Refresh navigate
		System.out.println("Before Rerfresh window id :"+driver.getWindowHandle());
		driver.navigate().refresh();
		System.out.println("After Rerfresh window id :"+driver.getWindowHandle());
		
		
	}

}
