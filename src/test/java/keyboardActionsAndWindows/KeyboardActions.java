package keyboardActionsAndWindows;

import java.security.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyboardActions {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://text-compare.com/");
		 
		 driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Selenium");
		 
		 Actions act = new Actions(driver);
		 
//		 #using keydown to click and keyup to release
		 
//		 ctrl +A 
		 
		 act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		 System.out.println("Selected..");
		 
//		 ctrl + C
		 
		 act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		 System.out.println("Copied..");
		 
//		 tab
		 act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 System.out.println("Tab ..");
		 
//		Ctrl + V
		 
		 act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		 System.out.println("Pasted...");
		 
//		 Enter
		 
		 act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		 System.out.println("Enter...");
		 
//		 Ctrl+shift+V
		 
		 act.keyDown(Keys.CONTROL)//pressed control
		 	.keyDown(Keys.SHIFT)//pressed shift
		 	.sendKeys("V")//pressed V
		 	.keyUp(Keys.SHIFT)//released shift
		 	.keyUp(Keys.CONTROL)//released control
		 	.perform();//performed the action
		 
		 System.out.println("Pasted..");
		 Thread.sleep(3000);
		 
		 driver.quit();
		 
	}

}
