package chromeDriverExe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFile {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
			    System.getProperty("user.dir") + "\\chromeDriver\\chromedriver.exe");

		 WebDriver driver = new ChromeDriver();

	        // Maximize window BEFORE entering URL
	        driver.manage().window().maximize();
	        
	        System.out.println("Maximizing Window......");

	        // Implicit wait for all elements
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Open OrangeHRM demo login page
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        // Find username and enter
	        WebElement username = driver.findElement(By.name("username"));
	        username.sendKeys("Admin");

	        // Find password and enter
	        WebElement password = driver.findElement(By.name("password"));
	        password.sendKeys("admin123");

	        // Click login
	        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
	        loginBtn.click();

	        // Verify Dashboard text in page
	        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	        String text = dashboardHeader.getText();

	        if (text.contains("Dashboard")) {
	            System.out.println("Dashboard found. Login successful.");
	        } else {
	            System.out.println("Dashboard not found.");
	        }
	        System.out.println("Closing Driver....");
	        driver.close();


	}

}
