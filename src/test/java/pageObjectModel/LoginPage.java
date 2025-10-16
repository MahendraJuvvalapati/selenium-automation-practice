package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	 public LoginPage(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 
	 //Locators
	 
	 By userNameInput=By.name("username");
	 By passwordInput=By.name("password");
	 By loginBtn=By.cssSelector("button[type='submit']");
	 By invalidCreds=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	 
	 public void enterUserName(String userName)
	 {
		 driver.findElement(userNameInput).sendKeys(userName);
	 }
	 
	 public void enterPassword(String password)
	 {
		 driver.findElement(passwordInput).sendKeys(password);;
	 }
	 
	 public void clickOnLogin()
	 {
		 driver.findElement(loginBtn).click();
	 }
	 
	 public boolean isLoginSuccesful()
	 {
		 return driver.findElements(invalidCreds).isEmpty();
	 }
	 
	 public boolean loginToApplication(String userName,String password)
	 {
		 enterUserName(userName);
		 enterPassword(password);
		 clickOnLogin();
		 return isLoginSuccesful();
	 }

}
