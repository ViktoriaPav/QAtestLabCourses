package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {
    private static WebDriver driver = initChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement login = findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password = findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitLogin = findElement(By.name("submitLogin"));
        clickOn(submitLogin);
        WebElement userProfile = findElement(By.cssSelector(".img-thumbnail"));
        clickOn(userProfile);
        WebElement logout = findElement(By.id("header_logout"));
        clickOn(logout);

        //close browser
        driver.quit();

    }
    public static WebElement findElement(By locator){
        WebElement element = driver.findElement(locator);
        return element;
    }

    public static void clickOn(WebElement element) {
        element.click();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("/chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
