package testNG;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🔹 Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test failed: " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = ((Listener) testClass).driver;

        if (driver != null) {
            try {
                // wait a bit to ensure page loaded
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            takeScreenshot(driver, result.getName());
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("▶️ Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Suite finished: " + context.getName());
    }

    // Utility method to take screenshot
    public void takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileHandler.createDir(new File(System.getProperty("user.dir") + "/screenshots"));
            FileHandler.copy(src, new File(path));
            System.out.println("📸 Screenshot saved: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
