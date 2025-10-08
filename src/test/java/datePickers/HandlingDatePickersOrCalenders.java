package datePickers;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDatePickersOrCalenders {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame);
		
//		method:1 using sendKeys if it is input
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2023");
		
		String selectedDate = driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
		System.out.println("The selected date is: " + selectedDate);

		
//		#method2 using date picker from calender
		
		String date="19";
		String month="October";
		String year="2001";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		switchToYearAndMonth(driver,year,month,date);
		
		String selectedNewDate = driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
		System.out.println("The selected New date is: " + selectedNewDate);
		
		Thread.sleep(5000);
		driver.quit();
		

	}

	public static void switchToYearAndMonth(WebDriver driver, String year, String month, String date) {
		
        while (true) {
            // Get currently displayed month and year from calendar header
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // ✅ Case 1: Both month and year match
            if (actualYear.equals(year) && actualMonth.equals(month)) {
                selectDate(driver, date);
                break;
            }

            // ✅ Case 2: Different year
            else if (Integer.parseInt(actualYear) > Integer.parseInt(year)) {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            } 
            else if (Integer.parseInt(actualYear) < Integer.parseInt(year)) {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } 

            // ✅ Case 3: Same year, different month
            else if (actualYear.equals(year)) {
                int actualMonthNum = getMonthNumber(actualMonth);
                int targetMonthNum = getMonthNumber(month);

                if (actualMonthNum > targetMonthNum) {
                    driver.findElement(By.xpath("//a[@title='Prev']")).click();
                } else {
                    driver.findElement(By.xpath("//a[@title='Next']")).click();
                }
            }
        }
    }

	public static void selectDate(WebDriver driver, String date) {
		List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele : AllDates)
		{
			String ActualDate=ele.getText();
			
			if(ActualDate.equals(date))
			{
				ele.click();
			}
		}
		
	}
	
	 private static int getMonthNumber(String monthName) {
	        Map<String, Integer> monthMap = new HashMap<>();
	        monthMap.put("January", 1);
	        monthMap.put("February", 2);
	        monthMap.put("March", 3);
	        monthMap.put("April", 4);
	        monthMap.put("May", 5);
	        monthMap.put("June", 6);
	        monthMap.put("July", 7);
	        monthMap.put("August", 8);
	        monthMap.put("September", 9);
	        monthMap.put("October", 10);
	        monthMap.put("November", 11);
	        monthMap.put("December", 12);

	        return monthMap.getOrDefault(monthName, 0);
	    }

}
