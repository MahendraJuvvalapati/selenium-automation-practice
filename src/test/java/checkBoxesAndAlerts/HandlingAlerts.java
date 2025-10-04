package checkBoxesAndAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 
		 driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 
		 Thread.sleep(3000);
//		 #ONLY accept
		  driver.switchTo().alert().accept();
		  
		  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		  Thread.sleep(3000);
//		  #Accept or dismiss
		  driver.switchTo().alert().accept();
		  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		  Thread.sleep(3000);
		  driver.switchTo().alert().dismiss();
		  
		  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		  
//		  #enter data into alert
		  
		  driver.switchTo().alert().sendKeys("Selenium");
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept();
		  
		  String result=driver.findElement(By.id("result")).getText();
		  
		  System.out.println(result.contains("Selenium"));
		  driver.quit();
	}

}
