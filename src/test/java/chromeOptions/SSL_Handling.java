package chromeOptions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Handling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true); // setting true for security
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
