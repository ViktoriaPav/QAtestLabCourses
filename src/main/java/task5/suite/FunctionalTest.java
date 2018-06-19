package task5.suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class FunctionalTest extends Assert {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    protected WebDriver getDriver(String browser){
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", FunctionalTest.class.getResource("/chromedriver.exe").getPath());
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", FunctionalTest.class.getResource("/geckodriver.exe").getPath());
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
/*
    @BeforeTest
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", FunctionalTest.class.getResource("/chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }*/

    @AfterMethod
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

