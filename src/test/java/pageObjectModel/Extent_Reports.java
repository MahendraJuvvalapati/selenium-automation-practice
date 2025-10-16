package pageObjectModel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
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

        // Timestamped report path
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String reportDir = System.getProperty("user.dir") + "/reports";
        new File(reportDir).mkdirs();
        String reportPath = reportDir + "/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Suite finished: " + context.getName());
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getName();
        ExtentTest classNode = classNodeMap.computeIfAbsent(className, name -> extent.createTest(className));

        ExtentTest methodNode = classNode.createNode(result.getMethod().getMethodName());
        test.set(methodNode);

        result.setAttribute("startTime", LocalDateTime.now());

        System.out.println("🔹 Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LocalDateTime startTime = (LocalDateTime) result.getAttribute("startTime");
        LocalDateTime endTime = LocalDateTime.now();
        long duration = Duration.between(startTime, endTime).toMillis();

        System.out.println("✅ Test passed: " + result.getName() + " (" + duration + " ms)");
        test.get().log(Status.PASS, "Test passed in " + duration + " ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LocalDateTime startTime = (LocalDateTime) result.getAttribute("startTime");
        LocalDateTime endTime = LocalDateTime.now();
        long duration = Duration.between(startTime, endTime).toMillis();

        System.out.println("❌ Test failed: " + result.getName() + " (" + duration + " ms)");
        test.get().log(Status.FAIL, result.getThrowable());
        test.get().log(Status.FAIL, "Failed in " + duration + " ms");

        WebDriver driver = extractDriver(result);

        if (driver != null) {
            try {
                Thread.sleep(2000); // small wait for stability
                String screenshotPath = takeScreenshot(driver, result.getName());
                if (screenshotPath != null) {
                    test.get().addScreenCaptureFromPath(screenshotPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test skipped: " + result.getName());
        test.get().log(Status.SKIP, "Test skipped");
    }

    // ✅ Utility: Safely extract driver from test or BaseTest
    private WebDriver extractDriver(ITestResult result) {
        Object testInstance = result.getInstance();
        Field driverField = getDriverField(testInstance.getClass());

        if (driverField != null) {
            try {
                driverField.setAccessible(true);
                return (WebDriver) driverField.get(testInstance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ No WebDriver field found in class hierarchy: "
                    + testInstance.getClass().getSimpleName());
        }
        return null;
    }

    // ✅ Searches current and superclasses for “driver”
    private Field getDriverField(Class<?> clazz) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField("driver");
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass(); // check BaseTest and above
            }
        }
        return null;
    }

    // ✅ Screenshot utility
    public String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String dir = System.getProperty("user.dir") + "/screenshots";
        new File(dir).mkdirs();
        String path = dir + "/" + testName + "_" + timestamp + ".png";

        try {
            FileHandler.copy(src, new File(path));
            System.out.println("📸 Screenshot saved: " + path);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
