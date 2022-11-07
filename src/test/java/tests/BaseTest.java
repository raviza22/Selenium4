package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.FileUtil;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public FileUtil fileUtil;
    protected String user, pass;

    @BeforeTest
    public void setup() {
        /* Create Driver using WebDriverManager

        // Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

         */

        // Create Driver using Selenium Manager

        fileUtil = new FileUtil();
        String browser = fileUtil.getBrowserConfig();
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        else {
            System.out.println("Browser is not supported");
        }

        driver.manage().window().maximize();
        driver.get(fileUtil.getAppURL());
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        // Get test data
        user = fileUtil.getUsername();
        pass = fileUtil.getPassword();
    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
