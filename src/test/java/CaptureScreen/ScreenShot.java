package CaptureScreen;

import common.BaseTest;
import keywords.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import Page.RegisterPage;
//chạy độc lạp
public class ScreenShot extends BaseTest {
    public WebDriver driverS;
    public ScreenShot(WebDriver driver){
        this.driverS=driver;
    }
    @Test
    public void test(){
        RegisterPage rs=new RegisterPage();

        rs.verifyHeaderRegisterPage();

    }

    public void ScreenShot(Method method) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        File theDir = new File("./screenshots/");//chạy code xong sẽ tự tạo file screen shot trên cây thư mục
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        try {
            FileHandler.copy(source, new File("./screenshots/"+method.getName()+".png"));//đường dẫn của hình chụp đc sau khi chạy code
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot success !!");

    }
}