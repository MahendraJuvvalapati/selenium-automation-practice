package keyboardActionsAndWindows;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAndTabs {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://text-compare.com/");
		 
//		 #switch to new tab
		 
		 driver.switchTo().newWindow(WindowType.TAB);
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 
//		 #switch to new window
		 
		 driver.switchTo().newWindow(WindowType.WINDOW);
		 
		 driver.get("https://testautomationpractice.blogspot.com/");

	}

}
