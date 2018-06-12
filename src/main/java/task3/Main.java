package task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", Main.class.getResource("/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(LoginPassword.LOGIN, LoginPassword.PASSWORD);
        DashboardPage dashboardPage = new DashboardPage(driver);
        //dashboardPage.clickOnMenuCatalog();
        dashboardPage.clickOnCatalogCategory();

    }
}
