package screenshots;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShots {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		TakesScreenshot ts=driver; //declaration
		
//		Full page Screenshot
		File fullScr = ts.getScreenshotAs(OutputType.FILE);
		
		File fullscrDest = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\screenshots\\FullPage.png");
		
//		#copying the screenhot to target loc
		fullScr.renameTo(fullscrDest);
		System.out.println("Taken full page screenshot...");
		
//		Taking specific part of page
		
		WebElement ele = driver.findElement(By.xpath("//td[@class='columns-cell']"));
		
		File partscr = ele.getScreenshotAs(OutputType.FILE);
		
		File partscrDest = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\screenshots\\somePart.png");
		
		partscr.renameTo(partscrDest);
		
		System.out.println("Taken Some part of page scrennshot....");
		
//		Taking specific element of page
		
		WebElement element = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		
		File  elementScr= element.getScreenshotAs(OutputType.FILE);
		
		File elementScrDest = new File("D:\\Automation practice\\javaSelenium\\com.demo.selenium\\screenshots\\element.png");
		
		elementScr.renameTo(elementScrDest);
		
		System.out.println("Taken an element screenshot....");
		
		driver.quit();
		
		

	}

}
