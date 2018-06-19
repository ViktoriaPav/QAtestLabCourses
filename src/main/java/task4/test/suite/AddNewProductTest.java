package task4.test.suite;

import org.testng.Assert;
import org.testng.annotations.Test;
import task4.*;

import java.util.List;

public class AddNewProductTest extends FunctionalTest {

    private Product randomProduct = new Product(Helper.randomString(), Helper.randomInteger(100), Helper.randomDouble(0.1, 100.0));

    @Test
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
        Product actualProduct = null;
        LoginTest loginTest = new LoginTest();
        loginTest.loginTest();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnCatalog();

        driver.navigate().refresh();
        ProductPage productPage = new ProductPage(driver);
        productPage.filterProduct(randomProduct);
        actualProduct = productPage.firstProduct();
        assertEquals(actualProduct, randomProduct);

        /*
        List<Product> productList = productPage.getAllProductsOnThePage();

        Product createdProduct = null;
        for (Product product : productList) {
            if (product.equals(randomProduct)) {
                createdProduct = product;
                System.out.println(createdProduct.toString());
                break;
            }
        }
        assertEquals(createdProduct, randomProduct, "Products are not equals");
        */
    }
}
