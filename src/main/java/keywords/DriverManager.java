package keywords;

import org.openqa.selenium.WebDriver;

public class DriverManager {


    private static final ThreadLocal<WebDriver> driverDriverManager = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driverDriverManager.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driverDriverManager.set(driver);
    }

    public static void quit() {
        DriverManager.driverDriverManager.get().quit();
        driverDriverManager.remove();
    }

}
