package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		System.out.println("No of rows : "+ rows);
		
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		System.out.println("No of columns : "+ columns);
		
//		#printing headers
		 
		List<WebElement> headers = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		
		for(WebElement ele :headers)
		{
			System.out.print(ele.getText()+" ");
		}
		System.out.println();
		
//		#printing all the data from table
		for(int i=2;i<=rows;i++)
		{
			for(int j=1;j<=columns;j++)
			{
				String Value =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				
				System.out.print(Value+" ");
			}
			System.out.println();
		}

//		#print the price of all books
		int orgPrice =0;
		for(int i=2;i<=rows;i++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			orgPrice=orgPrice+ Integer.parseInt(price);
		}
		
		System.out.println("Total Price of all books :"+orgPrice);
		
//		find the Highest price and name of book
		int lowestPrice=Integer.MAX_VALUE;
		String BookName="";
		for(int i=2;i<=rows;i++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			int numPrice=Integer.parseInt(price);
			
			if(numPrice <= lowestPrice)
			{
				lowestPrice=numPrice;
				BookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
			}
		}
		
		System.out.println(BookName+" :"+ lowestPrice);
		
		driver.quit();
	}

}
