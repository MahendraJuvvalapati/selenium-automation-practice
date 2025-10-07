package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTables {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
//		#table headers
		List<WebElement> Headers = driver.findElements(By.xpath("//table[@id='productTable']//th"));
//		printing headers
		for (WebElement ele : Headers) {
			System.out.print(ele.getText() + "\t");
		}
		System.out.println();
		
//		#get no of pages
		int noOfPages=driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		
//		loop for pages
		for(int i=1;i<=noOfPages;i++)
		{
//			#switchig pages
			driver.findElement(By.xpath("//ul[@id='pagination']//li["+i+"]")).click();
			
//			get No of rows of table
			int noOFRows=driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
//			get No of columns of table			
			int noOFColumns=driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
			
			
			for(int j=1;j<noOFRows;j++)
			{
				for(int k=1;k<=noOFColumns;k++)
				{
					WebElement element=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td["+k+"]"));
					
					String data=element.getText();
					
					System.out.print(data+" ");
					if(k==noOFColumns)	
					{
						WebElement checkbox=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td["+k+"]//input"));
						checkbox.click();
						System.out.print(checkbox.isSelected());
						
					}
				}
				System.out.println();
			}
			
		}
	}

}
