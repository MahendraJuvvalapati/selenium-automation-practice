package checkBoxesAndAlerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://qavalidation.com/demo-form/");
		
//		#singleCheckBox
		driver.findElement(By.xpath("//input[@id='g4072-skills-Functional testing']")).click();
		
		boolean isChecked=driver.findElement(By.xpath("//input[@id='g4072-skills-Functional testing']")).isSelected();
		
		System.out.println("The Check is Selected or not ? :"+isChecked);
		driver.findElement(By.xpath("//input[@id='g4072-skills-Functional testing']")).click(); //unchecking
		
//		#MultipleCheckBoxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='checkbox-multiple  grunion-field']"));
		for(WebElement ele: checkBoxes)
		{
			ele.click();
		}
		
//		#unchecking first 2 check boxes
		for(int i=0;i<2;i++)
		{
			checkBoxes.get(i).click();
		}
//	    checking in unchecked/ unchecking if checked
		for(int i=0;i<checkBoxes.size();i++)
		{
			WebElement element = checkBoxes.get(i);
			if(!element.isSelected())
			{
				element.click();
			}
		}

	}

}
