package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

// ✅ Add the @Listeners
//@Listeners(testNG.MyListeners.class)
public class Listener {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openURl() { // pass
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("✅ Browser launched and navigated to OrangeHRM login page");
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException { // fail
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("✅ Logged in successfully");
        Assert.fail();
    }

    @Test(dependsOnMethods = "loginTest") // skipped
    public void logoutTest() {
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        System.out.println("✅ Logged out successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Browser closed");
    }
}
