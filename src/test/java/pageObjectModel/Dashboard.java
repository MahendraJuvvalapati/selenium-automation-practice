package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

WebDriver driver;
	
	//Constructor
	 public Dashboard(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 
	 By profile=By.cssSelector(".oxd-userdropdown-name");
	 By logOut=By.xpath("//a[normalize-space()='Logout']");
	 
	 public void logOut()
	 {
		 driver.findElement(profile).click();
		 driver.findElement(logOut).click();
	 }
	 
}
