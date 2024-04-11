package common;

import Helpers.CaptureHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {


//    @BeforeMethod
//    @Parameters({"browser"})
//    public void createBrowser(String browser){
//        System.out.println("Start with test");
//        =new EdgeDriver();
//        .manage().window().maximize();
//        .manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//
//    }

    @BeforeMethod (alwaysRun = true)
    @Parameters({"browser"})
    public void createDriver(@Optional("edge") String browserName) {
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice..");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser..");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser..");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser..");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod (alwaysRun = true)
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }


//    @AfterMethod
//    public void closeBrowser(ITestResult rs, Method m) {
//        WebDriver 
//        WebUI.sleep(2);
//        if (rs.getStatus()==ITestResult.FAILURE){
////            CaptureHelper.captureScreenshot(m.getName(),);
//            CaptureHelper.stopRecord();
//        }
//
//        System.out.println("Close browser from BaseTest..");
//        .quit();
//    }

}


