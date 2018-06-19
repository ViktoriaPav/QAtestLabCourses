package task4.test.suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task4.PageObject;
import task4.Product;

public class ProductBeforeLoggingPage extends PageObject {

    @FindBy(className = "h1")
    private WebElement productName;

    @FindBy(className = "current-price")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class = 'product-quantities']/span")
    private WebElement quantityProducts;


    public Product actualProduct() {
        String name = productName.getText().toLowerCase();
        Integer quantity = Integer.valueOf(quantityProducts.getText().replace("Товары", "").replace(" ", ""));
        Double price = Double.parseDouble(productPrice.getText().replace("₴", "").replace(",", "."));

        Product product = new Product(name, quantity, price);
        return product;
    }

    public ProductBeforeLoggingPage(WebDriver driver) {
        super(driver);
    }
}
