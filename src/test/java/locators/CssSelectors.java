package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://qavalidation.com/demo-form/");

//      # tag id    tag#id
		driver.findElement(By.cssSelector("input#g4072-email")).sendKeys("Selenium@test.com");

//      # tag class   tag.class

		driver.findElement(By.cssSelector("input.grunion-field.name")).sendKeys("Selenium");

//      #tag attribute  tag[attribute=value"]

		driver.findElement(By.cssSelector("input[name='g4072-phonenumber']")).sendKeys("1234568907");

//      #tag class attribute  tag.className[attribute=value]}

		driver.findElement(By.cssSelector("input.grunion-field[name='g4072-email']")).clear();
		driver.findElement(By.cssSelector("input.grunion-field[name='g4072-email']")).sendKeys("test@test.com");

		driver.findElement(By.cssSelector("input.grunion-field[id='g4072-fullname']")).clear();
		driver.findElement(By.cssSelector("input.grunion-field[id='g4072-fullname']")).sendKeys("TesterQA");
	}

}
