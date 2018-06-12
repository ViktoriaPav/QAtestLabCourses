package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckMainMenuTest {
    private static WebDriver driver = initChromeDriver();
    private static String pageTitle;
    private static String pageTitleAfterRefresh;

    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Open start page
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        //Enter login and password
        WebElement login = findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password = findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitLogin = findElement(By.name("submitLogin"));
        clickOn(submitLogin);

        //Menu locators
        By dashboard = By.id("tab-AdminDashboard");
        By orders = By.id("subtab-AdminParentOrders");
        By catalog = By.id("subtab-AdminCatalog");
        By customer = By.xpath("//*[@class='main-menu']/li[5]");
        By supportService = By.xpath("//*[@class='menu']/li[6]");
        By statistics = By.id("subtab-AdminStats");
        By modules = By.id("subtab-AdminParentModulesSf");
        By design = By.xpath("//*[@class='main-menu']/li[10]");
        By delivery = By.id("subtab-AdminParentShipping");
        By paymentMethod = By.id("subtab-AdminParentPayment");
        By international = By.id("subtab-AdminInternational");
        By shopParameters = By.id("subtab-ShopParameters");
        By configuration = By.id("subtab-AdminAdvancedParameters");

        By[] menuElements = {dashboard, orders, catalog, customer, supportService, statistics, modules, design, delivery, paymentMethod, international, shopParameters, configuration};

        //Page title locators
        By titleDashboardPage = By.className("page-title");
        By titleOrdersPage = By.className("page-title");
        By titleCatalogPage = By.cssSelector(".header-toolbar .title");
        By titleCustomersPage = By.className("page-title");
        By titleSupportService = By.className("page-title");
        By titleStatisticPage = By.className("page-title");
        By titleModulePage = By.cssSelector(".header-toolbar .title");
        By titleDesignPage = By.cssSelector(".page-head .page-title");
        By titleDeliveryPage = By.className("page-title");
        By titlePaymentMethodPage = By.className("page-title");
        By titleInternationalPage = By.className("page-title");
        By titleShopParametersPage = By.className("page-title");
        By titleConfigurationPage = By.className("page-title");

        By[] pageTitles = {titleDashboardPage, titleOrdersPage, titleCatalogPage, titleCustomersPage, titleSupportService, titleStatisticPage, titleModulePage, titleDesignPage, titleDeliveryPage, titlePaymentMethodPage, titleInternationalPage, titleShopParametersPage, titleConfigurationPage};

        for (int i = 0; i < menuElements.length; i++) {
            clickOn(findElement(menuElements[i]));
            verifyPageTitleAfterRefresh(pageTitles[i]);
        }

        //logout
        //Element photo
        clickOn(findElement(By.cssSelector(".img-thumbnail")));

        WebElement logout = findElement(By.id("header_logout"));
        clickOn(logout);

        //close browser
        driver.quit();
    }

    public static boolean verifyPageTitleAfterRefresh(By title) {
        pageTitle = findElement(title).getText();
        System.out.println("Current page: " + pageTitle);
        driver.navigate().refresh();
        pageTitleAfterRefresh = findElement(title).getText();
        if (pageTitleAfterRefresh.equals(pageTitle)) {
            System.out.println("Page Title don't change after page refresh: " + pageTitleAfterRefresh);
            return true;
        } else {
            System.out.println("Page Title changed after page refresh: " + pageTitleAfterRefresh);
            return false;
        }
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
