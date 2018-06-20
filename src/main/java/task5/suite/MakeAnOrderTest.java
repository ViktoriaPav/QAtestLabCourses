package task5.suite;

import org.testng.annotations.Test;
import task5.HomePage;
import task5.ProductBeforeLoggingPage;
import task5.ProductsPageBeforeLogging;

public class MakeAnOrderTest extends FunctionalTest {

    @Test
    public void makeOrderTest() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        task5.HomePage homePage = new HomePage(driver);
        homePage.clickAllProductsButton();

        ProductsPageBeforeLogging productsPageBeforeLogging = new ProductsPageBeforeLogging(driver);

        productsPageBeforeLogging.clickFirstProduct();

        ProductBeforeLoggingPage productBeforeLoggingPage = new ProductBeforeLoggingPage(driver);
        productBeforeLoggingPage.addToCart();
        productBeforeLoggingPage.clickOnCheckoutButton();

    }

}
