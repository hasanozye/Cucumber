package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (drivers.get() == null) {
            switch (browser) {
                case FIREFOX -> {
                    drivers.set(new FirefoxDriver());
                }
                case EDGE -> {
                    drivers.set(new EdgeDriver());
                }
                default -> {
                    drivers.set(new ChromeDriver());
                }
            }
        }
        return drivers.get();
    }

    public static void tearDown() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
