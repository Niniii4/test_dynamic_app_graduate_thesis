package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriverForBrowserWithValue(String driverType) {
        String driverVersion = PropertiesReader.readFromProperties(TestConfigurationConstants.MY_PROPERTIES_PATH, TestConfigurationConstants.DRIVER_TYPE_VERSION);
        WebDriver driver = null;
        if (driverType.equals("chrome")) {
            ChromeDriverManager.getInstance().version(driverVersion).setup();
            driver = new ChromeDriver();
        }
        if (driverType.equals("chrome-headless")) {
            ChromeDriverManager.getInstance().version(driverVersion).setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1920x1080");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--allow-insecure-localhost");
            driver = new ChromeDriver(chromeOptions);
        }
        if (driverType.equals("firefox")) {
            FirefoxDriverManager.getInstance().version(driverVersion).setup();
            driver = new FirefoxDriver();
        }
        if (driver == null) {
            throw new RuntimeException("The driver wasn't initialised");
        }
        driver.manage().window().maximize();
        return driver;
    }

}
