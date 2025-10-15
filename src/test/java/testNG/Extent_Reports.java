package testNG;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Reports implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static Map<String, ExtentTest> classNodeMap = new HashMap<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("▶️ Suite started: " + context.getName());

        // Report path
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        // Create folder if it doesn't exist
        new File(System.getProperty("user.dir") + "/reports").mkdirs();

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Suite finished: " + context.getName());
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getName();

        // Create class node only once
        ExtentTest classNode = classNodeMap.computeIfAbsent(className, name -> extent.createTest(className));

        // Create child node for this method
        ExtentTest methodNode = classNode.createNode(result.getMethod().getMethodName());
        test.set(methodNode);

        System.out.println("🔹 Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test passed: " + result.getName());
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test failed: " + result.getName());
        test.get().log(Status.FAIL, result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            Field driverField = testClass.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("⚠️ No WebDriver field found in class: " + testClass.getClass().getSimpleName());
        }

        if (driver != null) {
            try {
                Thread.sleep(3000); // small wait for page to render
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String screenshotPath = takeScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.get().addScreenCaptureFromPath(screenshotPath);
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test skipped: " + result.getName());
        test.get().log(Status.SKIP, "Test skipped");
    }

    // Screenshot utility
    public String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            new File(System.getProperty("user.dir") + "/screenshots").mkdirs();
            FileHandler.copy(src, new File(path));
            System.out.println("📸 Screenshot saved: " + path);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
