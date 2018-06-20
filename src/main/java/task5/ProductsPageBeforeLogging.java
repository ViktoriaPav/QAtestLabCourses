package task5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task5.PageObject;
import task5.Product;

public class ProductsPageBeforeLogging extends PageObject {

    @FindBy(className = "ui-autocomplete-input")
    WebElement searchField;

    @FindBy(xpath = "//form/button/i")
    WebElement searchFiealdButton;

    @FindBy(className = "product-title")
    WebElement titleProduct;

    @FindBy(className = "product-miniature js-product-miniature")
    WebElement firstProduct;

    @FindBy(xpath = "//*[@class = 'nav-item'][2]")
    WebElement moreAboutProduct;

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public void searchProduct(Product product) {
        searchField.clear();
        searchField.sendKeys(product.getName());
        searchFiealdButton.click();
        titleProduct.click();

    }

    public ProductsPageBeforeLogging(WebDriver driver) {
        super(driver);
    }
}
