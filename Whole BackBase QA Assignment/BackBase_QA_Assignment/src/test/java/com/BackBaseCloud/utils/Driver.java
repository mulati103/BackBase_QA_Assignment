package com.BackBaseCloud.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() { }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {
                String browser = ConfigurationReader.getProperty("browser");

                if (System.getProperty("browser") != null) {

                    System.out.println("Browser type was changed to: " + System.getProperty("browser"));
                    browser = System.getProperty("browser");
                }
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "remote-chrome":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            URL gridUrl = new URL("");
                            driverPool.set(new RemoteWebDriver(gridUrl, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "remote-firefox":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("firefox");
                            URL gridUrl = new URL("http://0.00.00:4444/wd/hub");
                            driverPool.set(new RemoteWebDriver(gridUrl, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        throw new RuntimeException("No such a browser yet!");
                }
            }
        }
        return driverPool.get();
    }
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
