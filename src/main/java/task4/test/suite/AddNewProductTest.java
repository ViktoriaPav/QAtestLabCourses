package task4.test.suite;

import org.testng.annotations.Test;
import task4.*;

public class AddNewProductTest extends FunctionalTest {

    private Product randomProduct = new Product(Helper.randomString(), Helper.randomInteger(100), Helper.randomDouble(0.1, 100.0));

    @Test()
    public void addNewProduct() throws InterruptedException {

        randomProduct = new Product(Helper.randomString(), Helper.randomInteger(100), Helper.randomDouble(0.1, 100.0));

        LoginTest loginTest = new LoginTest();
       loginTest.loginTest();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnSubMenuCatalogProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnNewProductButton();

        NewAddProductPage newAddProductPage = new NewAddProductPage(driver);
        newAddProductPage.addNewProduct(randomProduct);
        newAddProductPage.clickMenuCatalog();
        System.out.println(randomProduct.toString());
    }

    @Test
    public void checkNewProduct() {

        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        HomePage homePage = new HomePage(driver);
        homePage.clickAllProductsButton();

        ProductsPageBeforeLogging productsPageBeforeLogging = new ProductsPageBeforeLogging(driver);
        productsPageBeforeLogging.searchProduct(randomProduct);

        ProductBeforeLoggingPage productBeforeLoggingPage = new ProductBeforeLoggingPage(driver);
        Product actualProduct = productBeforeLoggingPage.actualProduct();
        assertEquals(actualProduct, randomProduct);
    }
}
