package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		#getting all links from page
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		List<WebElement> activeLinks = new ArrayList<>();
		
		List<WebElement> noHrefLinks = new ArrayList<>();

//		#storing valid links which has href value 
		for (WebElement link : allLinks) {
		    if (link.getAttribute("href") != null && !link.getAttribute("href").isEmpty()) {
		        activeLinks.add(link);
		    }
		    else
		    {
		    	noHrefLinks.add(link);
		    }
		}
		
//		getting response code of them and validation
		for (WebElement link : activeLinks) {
		    String url = link.getAttribute("href");
		    try {
		        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		        connection.setRequestMethod("HEAD"); // HEAD request is faster than GET
		        connection.connect();
		        int responseCode = connection.getResponseCode();

		        if (responseCode >= 400) {
		            System.out.println(url + " is a broken link - " + responseCode);
		        } else {
		            System.out.println(url + " is a valid link - " + responseCode);
		        }
		    } catch (Exception e) {
		        System.out.println(url + " is not reachable. Exception: " + e.getMessage());
		    }
		}

		System.out.println("Total no of Links :"+allLinks.size());
		
		System.out.println("Total no of Good Links :"+activeLinks.size());
		
		System.out.println("Total no of links without href Value :"+(allLinks.size()-activeLinks.size()));
		
		
		driver.quit();

	}

}
