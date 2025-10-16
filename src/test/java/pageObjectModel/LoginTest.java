package pageObjectModel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData")
	public void performLoginTests(String userName,String password)
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		LoginPage loginPage=new LoginPage(driver); //passing driver from base Test
		
		boolean isLoggedIn = loginPage.loginToApplication(userName, password);
		
		if(isLoggedIn)
		{
			Dashboard dashboard = new Dashboard(driver);
			dashboard.logOut();
		}
		else
		{
			Assert.fail("Login Failed with user :"+userName);
		}
	}
	
	@DataProvider(name="loginData",parallel=true)
	public String[][] getExcelData() throws IOException
	{
		String filepath = System.getProperty("user.dir") + "\\TestData\\credentials.xlsx";
		
		String SheetName = "Sheet1";
		return ExcelUtils.loginData(filepath, SheetName);
	}
}
