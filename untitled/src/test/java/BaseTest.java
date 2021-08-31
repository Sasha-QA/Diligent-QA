import helper.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;

    public WebDriver createWebDriver(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        String url = configFileReader.getApplicationUrl();
        String browser = configFileReader.getDriverType();

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        return driver;
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}
