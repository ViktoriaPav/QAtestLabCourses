package task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        EventFiringWebDriver e_driver;
        WebEventListener eventListener;

        String message = "Dog";

        System.setProperty("webdriver.chrome.driver", Main.class.getResource("/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        /*e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
*/
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        Category category = new Category(driver);
        CreateNewCategoryPage createNewCategoryPage = new CreateNewCategoryPage(driver);

        loginPage.login(LoginPassword.LOGIN, LoginPassword.PASSWORD);
        dashboardPage.clickOnCatalogCategory();
        category.addNewCategory();
        createNewCategoryPage.createNewCategory(message);
        category.verifyMessage();
        category.filterCategory(message);

    }
}
