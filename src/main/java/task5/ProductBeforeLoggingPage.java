package task5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task5.PageObject;
import task5.Product;

public class ProductBeforeLoggingPage extends PageObject {

    @FindBy(className = "h1")
    private WebElement productName;

    @FindBy(className = "current-price")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class = 'product-quantities']/span")
    private WebElement quantityProducts;

    @FindBy(className = "add-to-cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class = 'cart-content']/a")
    WebElement checkoutButton;

    public void clickOnCheckoutButton() {
        if (checkoutButton.isDisplayed()) {
            checkoutButton.click();
        }else {
            System.out.println("button is not display");
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

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
